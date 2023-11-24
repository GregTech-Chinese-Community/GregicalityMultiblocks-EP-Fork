package gregicality.multiblocks.common.metatileentities.multiblock.standard;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;

import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.recipes.RecipeMaps;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.cube.OrientedOverlayRenderer;
import gregtech.common.blocks.BlockBoilerCasing;
import gregtech.common.blocks.BlockMetalCasing;
import gregtech.common.blocks.BlockTurbineCasing;
import gregtech.common.blocks.MetaBlocks;

import gregicality.multiblocks.api.metatileentity.GCYMRecipeMapMultiblockController;
import gregicality.multiblocks.api.render.GCYMTextures;
import gregicality.multiblocks.api.unification.GCYMMaterials;
import gregicality.multiblocks.common.block.GCYMMetaBlocks;
import gregicality.multiblocks.common.block.blocks.BlockLargeMultiblockCasing;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

public class MetaTileEntityLargeMixer extends GCYMRecipeMapMultiblockController {

    public MetaTileEntityLargeMixer(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, RecipeMaps.MIXER_RECIPES);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new MetaTileEntityLargeMixer(this.metaTileEntityId);
    }

    @Nonnull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("#XXX#", "#XXX#", "#XXX#", "#XXX#", "#XXX#", "##F##")
                .aisle("XXXXX", "X C X", "X   X", "X C X", "X   X", "##F##")
                .aisle("XXXXX", "XCPCX", "X P X", "XCPCX", "X P X", "FFTFF")
                .aisle("XXXXX", "X C X", "X   X", "X C X", "X   X", "##F##")
                .aisle("#XXX#", "#XSX#", "#XXX#", "#XXX#", "#XXX#", "##F##")
                .where('S', this.selfPredicate())
                .where('X', states(getCasingState())
                        .setMinGlobalLimited(50)
                        .or(autoAbilities()))
                .where('P', states(getBoilerCasingState()))
                .where('C', states(getSecondCasingState()))
                .where('T', tieredCasing()
                        .or(states(getThirdCasingState())))
                .where('F', states(getFrameState()))
                .where(' ', air())
                .where('#', any())
                .build();
    }

    private static IBlockState getCasingState() {
        return GCYMMetaBlocks.LARGE_MULTIBLOCK_CASING.getState(BlockLargeMultiblockCasing.CasingType.MIXER_CASING);
    }

    private static IBlockState getBoilerCasingState() {
        return MetaBlocks.BOILER_CASING.getState(BlockBoilerCasing.BoilerCasingType.POLYTETRAFLUOROETHYLENE_PIPE);
    }

    private static IBlockState getSecondCasingState() {
        return MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.PTFE_INERT_CASING);
    }

    private static IBlockState getThirdCasingState() {
        return MetaBlocks.TURBINE_CASING.getState(BlockTurbineCasing.TurbineCasingType.STAINLESS_STEEL_GEARBOX);
    }

    private static IBlockState getFrameState() {
        return MetaBlocks.FRAMES.get(GCYMMaterials.HastelloyX).getBlock(GCYMMaterials.HastelloyX);
    }

    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return GCYMTextures.MIXER_CASING;
    }

    @Nonnull
    @Override
    protected OrientedOverlayRenderer getFrontOverlay() {
        return GCYMTextures.LARGE_MIXER_OVERLAY;
    }

    @Override
    public String[] getDescription() {
        List<String> list = new ArrayList<>();
        list.add(I18n.format("gcym.machine.large_mixer.description"));
        return list.toArray(new String[0]);
    }

    @Override
    public boolean canBeDistinct() {
        return true;
    }
}

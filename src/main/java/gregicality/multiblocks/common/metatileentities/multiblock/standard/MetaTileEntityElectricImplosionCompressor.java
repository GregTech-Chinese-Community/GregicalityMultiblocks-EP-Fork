package gregicality.multiblocks.common.metatileentities.multiblock.standard;

import gregicality.multiblocks.api.metatileentity.GCYMRecipeMapMultiblockController;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;

import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.unification.material.Materials;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.Textures;
import gregtech.client.renderer.texture.cube.OrientedOverlayRenderer;
import gregtech.common.blocks.BlockBoilerCasing;
import gregtech.common.blocks.BlockGlassCasing;
import gregtech.common.blocks.BlockMetalCasing;
import gregtech.common.blocks.MetaBlocks;

import gregicality.multiblocks.api.render.GCYMTextures;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

public class MetaTileEntityElectricImplosionCompressor extends GCYMRecipeMapMultiblockController {

    public MetaTileEntityElectricImplosionCompressor(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, RecipeMaps.IMPLOSION_RECIPES);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new MetaTileEntityElectricImplosionCompressor(this.metaTileEntityId);
    }

    @Nonnull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("XXXXX", "F###F", "F###F", "F###F", "F###F", "XXXXX")
                .aisle("XXXXX", "#PGP#", "#PGP#", "#PGP#", "#PGP#", "XXXXX")
                .aisle("XXXXX", "#G G#", "#G G#", "#G G#", "#G G#", "XXMXX")
                .aisle("XXXXX", "#PGP#", "#PGP#", "#PGP#", "#PGP#", "XXXXX")
                .aisle("XXSXX", "F###F", "F###F", "F###F", "F###F", "XXXXX")
                .where('S', this.selfPredicate())
                .where('X', states(getCasingState())
                        .setMinGlobalLimited(40)
                        .or(autoAbilities(true, true, true, true, true, true, false)))
                .where('P', states(getBoilerCasingState()))
                .where('G', states(getGlassState()))
                .where('F', states(getFrameState()))
                .where(' ', air())
                .where('#', any())
                .where('M', abilities(MultiblockAbility.MUFFLER_HATCH))
                .build();
    }

    private static IBlockState getCasingState() {
        return MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.TUNGSTENSTEEL_ROBUST);
    }

    private static IBlockState getBoilerCasingState() {
        return MetaBlocks.BOILER_CASING.getState(BlockBoilerCasing.BoilerCasingType.TUNGSTENSTEEL_PIPE);
    }

    private static IBlockState getGlassState() {
        return MetaBlocks.TRANSPARENT_CASING.getState(BlockGlassCasing.CasingType.TEMPERED_GLASS);
    }

    private static IBlockState getFrameState() {
        return MetaBlocks.FRAMES.get(Materials.TungstenSteel).getBlock(Materials.TungstenSteel);
    }

    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return Textures.ROBUST_TUNGSTENSTEEL_CASING;
    }

    @Nonnull
    @Override
    protected OrientedOverlayRenderer getFrontOverlay() {
        return GCYMTextures.ELECTRIC_IMPLOSION_OVERLAY;
    }

    @Override
    public boolean hasMufflerMechanics() {
        return true;
    }

    @Override
    public String[] getDescription() {
        List<String> list = new ArrayList<>();
        list.add(I18n.format("gcym.machine.electric_implosion_compressor.description"));
        return list.toArray(new String[0]);
    }
}

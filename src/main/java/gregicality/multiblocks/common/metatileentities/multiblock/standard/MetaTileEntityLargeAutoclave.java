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
import gregtech.common.blocks.MetaBlocks;

import gregicality.multiblocks.api.metatileentity.GCYMRecipeMapMultiblockController;
import gregicality.multiblocks.api.render.GCYMTextures;
import gregicality.multiblocks.common.block.GCYMMetaBlocks;
import gregicality.multiblocks.common.block.blocks.BlockLargeMultiblockCasing;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

public class MetaTileEntityLargeAutoclave extends GCYMRecipeMapMultiblockController {

    public MetaTileEntityLargeAutoclave(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, RecipeMaps.AUTOCLAVE_RECIPES);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new MetaTileEntityLargeAutoclave(this.metaTileEntityId);
    }

    @Nonnull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("XXX", "XXX", "XXX")
                .aisle("XXX", "XCX", "XXX")
                .aisle("XXX", "XTX", "XXX")
                .aisle("XXX", "XCX", "XXX")
                .aisle("XXX", "XSX", "XXX")
                .where('S', this.selfPredicate())
                .where('X', states(getCasingState())
                        .setMinGlobalLimited(30)
                        .or(autoAbilities()))
                .where('C', states(getBoilerCasingState()))
                .where('T', tieredCasing()
                        .or(states(getBoilerCasingState())))
                .build();
    }

    private static IBlockState getCasingState() {
        return GCYMMetaBlocks.LARGE_MULTIBLOCK_CASING.getState(BlockLargeMultiblockCasing.CasingType.WATERTIGHT_CASING);
    }

    private static IBlockState getBoilerCasingState() {
        return MetaBlocks.BOILER_CASING.getState(BlockBoilerCasing.BoilerCasingType.STEEL_PIPE);
    }

    @Override
    public String[] getDescription() {
        List<String> list = new ArrayList<>();
        list.add(I18n.format("gcym.machine.large_autoclave.description"));
        return list.toArray(new String[0]);
    }

    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return GCYMTextures.WATERTIGHT_CASING;
    }

    @Nonnull
    @Override
    protected OrientedOverlayRenderer getFrontOverlay() {
        return GCYMTextures.LARGE_AUTOCLAVE_OVERLAY;
    }
}

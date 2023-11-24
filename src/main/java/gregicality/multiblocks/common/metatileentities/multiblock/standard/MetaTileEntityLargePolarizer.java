package gregicality.multiblocks.common.metatileentities.multiblock.standard;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;

import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.RecipeMaps;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.cube.OrientedOverlayRenderer;

import gregicality.multiblocks.api.metatileentity.GCYMRecipeMapMultiblockController;
import gregicality.multiblocks.api.render.GCYMTextures;
import gregicality.multiblocks.common.block.GCYMMetaBlocks;
import gregicality.multiblocks.common.block.blocks.BlockLargeMultiblockCasing;
import gregicality.multiblocks.common.block.blocks.BlockUniqueCasing;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

public class MetaTileEntityLargePolarizer extends GCYMRecipeMapMultiblockController {

    public MetaTileEntityLargePolarizer(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, new RecipeMap[] {
                RecipeMaps.POLARIZER_RECIPES,
                RecipeMaps.ELECTROMAGNETIC_SEPARATOR_RECIPES });
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new MetaTileEntityLargePolarizer(this.metaTileEntityId);
    }

    @Nonnull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("XXXXX", "XXXXX", "XXXXX")
                .aisle("XXXXX", "XCTCX", "XCXCX")
                .aisle("XXXXX", "XCTCX", "XCXCX")
                .aisle("XXXXX", "XXSXX", "XXXXX")
                .where('S', this.selfPredicate())
                .where('X', states(getCasingState())
                        .setMinGlobalLimited(35)
                        .or(autoAbilities()))
                .where('C', states(getUniqueCasingState()))
                .where('T', tieredCasing()
                        .or(air()))
                .build();
    }

    private static IBlockState getCasingState() {
        return GCYMMetaBlocks.LARGE_MULTIBLOCK_CASING
                .getState(BlockLargeMultiblockCasing.CasingType.NONCONDUCTING_CASING);
    }

    private static IBlockState getUniqueCasingState() {
        return GCYMMetaBlocks.UNIQUE_CASING.getState(BlockUniqueCasing.UniqueCasingType.MOLYBDENUM_DISILICIDE_COIL);
    }

    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return GCYMTextures.NONCONDUCTING_CASING;
    }

    @Nonnull
    @Override
    protected OrientedOverlayRenderer getFrontOverlay() {
        return GCYMTextures.LARGE_POLARIZER_OVERLAY;
    }

    @Override
    public String[] getDescription() {
        List<String> list = new ArrayList<>();
        list.add(I18n.format("gcym.machine.large_polarizer.description"));
        return list.toArray(new String[0]);
    }
}

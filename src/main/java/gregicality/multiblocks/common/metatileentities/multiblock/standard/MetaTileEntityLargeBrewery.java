package gregicality.multiblocks.common.metatileentities.multiblock.standard;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;

import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.RecipeMaps;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.cube.OrientedOverlayRenderer;
import gregtech.common.blocks.BlockBoilerCasing;
import gregtech.common.blocks.MetaBlocks;

import gregicality.multiblocks.api.metatileentity.GCYMRecipeMapMultiblockController;
import gregicality.multiblocks.api.render.GCYMTextures;
import gregicality.multiblocks.common.block.GCYMMetaBlocks;
import gregicality.multiblocks.common.block.blocks.BlockLargeMultiblockCasing;
import gregicality.multiblocks.common.block.blocks.BlockUniqueCasing;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

public class MetaTileEntityLargeBrewery extends GCYMRecipeMapMultiblockController {

    public MetaTileEntityLargeBrewery(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, new RecipeMap[] {
                RecipeMaps.BREWING_RECIPES,
                RecipeMaps.FERMENTING_RECIPES,
                RecipeMaps.FLUID_HEATER_RECIPES });
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new MetaTileEntityLargeBrewery(this.metaTileEntityId);
    }

    @Nonnull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("#XXX#", "#XXX#", "#XXX#", "#XXX#", "#####")
                .aisle("XXXXX", "XCCCX", "X   X", "XX XX", "##X##")
                .aisle("XXXXX", "XCPCX", "X T X", "X P X", "#XMX#")
                .aisle("XXXXX", "XCCCX", "X   X", "XX XX", "##X##")
                .aisle("#XXX#", "#XSX#", "#XXX#", "#XXX#", "#####")
                .where('S', this.selfPredicate())
                .where('X', states(getCasingState())
                        .setMinGlobalLimited(50)
                        .or(autoAbilities(true, true, true, true, true, true, false)))
                .where('C', states(getUniqueCasingState()))
                .where('P', states(getBoilerCasingState()))
                .where('M', abilities(MultiblockAbility.MUFFLER_HATCH))
                .where('T', tieredCasing()
                        .or(states(getBoilerCasingState())))
                .where(' ', air())
                .where('#', any())
                .build();
    }

    private static IBlockState getCasingState() {
        return GCYMMetaBlocks.LARGE_MULTIBLOCK_CASING
                .getState(BlockLargeMultiblockCasing.CasingType.CORROSION_PROOF_CASING);
    }

    private static IBlockState getUniqueCasingState() {
        return GCYMMetaBlocks.UNIQUE_CASING.getState(BlockUniqueCasing.UniqueCasingType.MOLYBDENUM_DISILICIDE_COIL);
    }

    private static IBlockState getBoilerCasingState() {
        return MetaBlocks.BOILER_CASING.getState(BlockBoilerCasing.BoilerCasingType.STEEL_PIPE);
    }

    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return GCYMTextures.CORROSION_PROOF_CASING;
    }

    @Nonnull
    @Override
    protected OrientedOverlayRenderer getFrontOverlay() {
        return GCYMTextures.LARGE_BREWERY_OVERLAY;
    }

    @Override
    public String[] getDescription() {
        List<String> list = new ArrayList<>();
        list.add(I18n.format("gcym.machine.large_brewer.description"));
        return list.toArray(new String[0]);
    }

    @Override
    public boolean hasMufflerMechanics() {
        return true;
    }
}

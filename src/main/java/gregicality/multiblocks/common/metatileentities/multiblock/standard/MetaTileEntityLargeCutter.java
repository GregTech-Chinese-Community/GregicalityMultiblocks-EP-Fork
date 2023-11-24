package gregicality.multiblocks.common.metatileentities.multiblock.standard;

import static gregtech.api.util.RelativeDirection.*;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Loader;

import org.jetbrains.annotations.NotNull;

import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.RecipeMaps;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.client.renderer.texture.cube.OrientedOverlayRenderer;
import gregtech.common.blocks.BlockGlassCasing;
import gregtech.common.blocks.MetaBlocks;

import gregicality.multiblocks.api.GCYMValues;
import gregicality.multiblocks.api.metatileentity.GCYMRecipeMapMultiblockController;
import gregicality.multiblocks.api.render.GCYMTextures;
import gregicality.multiblocks.common.block.GCYMMetaBlocks;
import gregicality.multiblocks.common.block.blocks.BlockLargeMultiblockCasing;
import gregicality.multiblocks.common.block.blocks.BlockUniqueCasing;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

public class MetaTileEntityLargeCutter extends GCYMRecipeMapMultiblockController {

    public MetaTileEntityLargeCutter(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, determineRecipeMaps());
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new MetaTileEntityLargeCutter(this.metaTileEntityId);
    }

    @Nonnull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start(FRONT, UP, RIGHT)
                .aisle("XXXX", "XXXX", "XXXX", "####")
                .aisle("XXXX", "ST X", "XXXX", "####")
                .aisle("XXXX", "XXXX", "XXXX", "XXXX")
                .aisle("XXXX", "GCCX", "G  X", "XXXX").setRepeatable(3)
                .aisle("XXXX", "XXXX", "XXXX", "XXXX")
                .where('S', this.selfPredicate())
                .where('X', states(getCasingState())
                        .setMinGlobalLimited(65)
                        .or(autoAbilities()))
                .where('G', states(getGlassState()))
                .where('C', states(getUniqueCasingState()))
                .where('T', tieredCasing()
                        .or(air()))
                .where(' ', air())
                .where('#', any())
                .build();
    }

    private static IBlockState getCasingState() {
        return GCYMMetaBlocks.LARGE_MULTIBLOCK_CASING.getState(BlockLargeMultiblockCasing.CasingType.CUTTER_CASING);
    }

    private static IBlockState getGlassState() {
        return MetaBlocks.TRANSPARENT_CASING.getState(BlockGlassCasing.CasingType.TEMPERED_GLASS);
    }

    private static IBlockState getUniqueCasingState() {
        return GCYMMetaBlocks.UNIQUE_CASING.getState(BlockUniqueCasing.UniqueCasingType.SLICING_BLADES);
    }

    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return GCYMTextures.CUTTER_CASING;
    }

    @Nonnull
    @Override
    protected OrientedOverlayRenderer getFrontOverlay() {
        return GCYMTextures.LARGE_CUTTER_OVERLAY;
    }

    @Override
    public String[] getDescription() {
        List<String> list = new ArrayList<>();
        list.add(I18n.format("gcym.machine.large_cutter.description"));
        return list.toArray(new String[0]);
    }

    private static @NotNull RecipeMap<?> @NotNull [] determineRecipeMaps() {
        RecipeMap<?> slicerMap = RecipeMap.getByName("slicer");
        if (Loader.isModLoaded(GCYMValues.GTFO_MODID) && slicerMap != null) {
            return new RecipeMap<?>[] { RecipeMaps.CUTTER_RECIPES, RecipeMaps.LATHE_RECIPES, slicerMap };
        }
        return new RecipeMap<?>[] { RecipeMaps.CUTTER_RECIPES, RecipeMaps.LATHE_RECIPES };
    }
}

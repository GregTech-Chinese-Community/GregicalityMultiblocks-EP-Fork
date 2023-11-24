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

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

public class MetaTileEntityLargeAssembler extends GCYMRecipeMapMultiblockController {

    public MetaTileEntityLargeAssembler(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, determineRecipeMaps());
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new MetaTileEntityLargeAssembler(this.metaTileEntityId);
    }

    @Nonnull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start(FRONT, UP, RIGHT)
                .aisle("XXX", "XXX", "XXX")
                .aisle("XXX", "C X", "CCX").setRepeatable(3)
                .aisle("XXX", "XXX", "XXX")
                .aisle("XXX", "X X", "#XX")
                .aisle("XXX", "STX", "#XX")
                .aisle("XXX", "X X", "#XX")
                .aisle("XXX", "XXX", "XXX")
                .where('S', this.selfPredicate())
                .where('X', states(getCasingState())
                        .setMinGlobalLimited(40)
                        .or(autoAbilities()))
                .where('C', states(getGlassState()))
                .where('T', tieredCasing()
                        .or(air()))
                .where(' ', air())
                .where('#', any())
                .build();
    }

    private static IBlockState getCasingState() {
        return GCYMMetaBlocks.LARGE_MULTIBLOCK_CASING.getState(BlockLargeMultiblockCasing.CasingType.ASSEMBLING_CASING);
    }

    private static IBlockState getGlassState() {
        return MetaBlocks.TRANSPARENT_CASING.getState(BlockGlassCasing.CasingType.TEMPERED_GLASS);
    }

    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return GCYMTextures.ASSEMBLING_CASING;
    }

    @Nonnull
    @Override
    protected OrientedOverlayRenderer getFrontOverlay() {
        return GCYMTextures.LARGE_ASSEMBLER_OVERLAY;
    }

    @Override
    public boolean canBeDistinct() {
        return true;
    }

    @Override
    public String[] getDescription() {
        List<String> list = new ArrayList<>();
        list.add(I18n.format("gcym.machine.large_assembler.description"));
        return list.toArray(new String[0]);
    }

    private static @NotNull RecipeMap<?> @NotNull [] determineRecipeMaps() {
        RecipeMap<?> cuisineAssemblerMap = RecipeMap.getByName("cuisine_assembler");
        if (Loader.isModLoaded(GCYMValues.GTFO_MODID) && cuisineAssemblerMap != null) {
            return new RecipeMap<?>[] { RecipeMaps.ASSEMBLER_RECIPES, cuisineAssemblerMap };
        }
        return new RecipeMap<?>[] { RecipeMaps.ASSEMBLER_RECIPES };
    }
}

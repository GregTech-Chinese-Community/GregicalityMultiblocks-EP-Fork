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
import gregtech.client.renderer.texture.Textures;
import gregtech.client.renderer.texture.cube.OrientedOverlayRenderer;
import gregtech.common.blocks.BlockBoilerCasing;
import gregtech.common.blocks.BlockGlassCasing;
import gregtech.common.blocks.BlockMetalCasing;
import gregtech.common.blocks.MetaBlocks;

import gregicality.multiblocks.api.metatileentity.GCYMRecipeMapMultiblockController;
import gregicality.multiblocks.api.render.GCYMTextures;
import gregicality.multiblocks.common.block.GCYMMetaBlocks;
import gregicality.multiblocks.common.block.blocks.BlockUniqueCasing;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

public class MetaTileEntityMegaVacuumFreezer extends GCYMRecipeMapMultiblockController {

    public MetaTileEntityMegaVacuumFreezer(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, RecipeMaps.VACUUM_RECIPES);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new MetaTileEntityMegaVacuumFreezer(this.metaTileEntityId);
    }

    @Nonnull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("XXXXXXX KKK", "XXXXXXX KVK", "XXXXXXX KVK", "XXXXXXX KVK", "XXXXXXX KKK", "XXXXXXX    ", "XXXXXXX    ")
                .aisle("XXXXXXX KVK", "XPPPPPPPPPV", "XPAPAPX VPV", "XPPPPPPPPPV", "XPAPAPX KVK", "XPPPPPX    ", "XXXXXXX    ")
                .aisle("XXXXXXX KVK", "XPAPAPX VPV", "XAAAAAX VPV", "XPAAAPX VPV", "XAAAAAX KVK", "XPAPAPX    ", "XXXXXXX    ")
                .aisle("XXXXXXX KVK", "XPAPAPPPPPV", "XAAAAAX VPV", "XPAAAPPPPPV", "XAAAAAX KVK", "XPAPAPX    ", "XXXXXXX    ")
                .aisle("XXXXXXX KKK", "XPPPPPX KVK", "XPAAAPX KVK", "XPAAAPX KVK", "XPAAAPX KKK", "XPPPPPX    ", "XXXXXXX    ")
                .aisle(" XXXXX     ", " XXSXX     ", " XGGGX     ", " XGGGX     ", " XGGGX     ", " XXXXX     ", "           ")
                .where('S', selfPredicate())
                .where('X', states(getCasingState())
                        .setMinGlobalLimited(140)
                        .or(autoAbilities()))
                .where('G', states(getGlassState()))
                .where('K', states(getSecondCasingState()))
                .where('V', states(getUniqueCasingState()))
                .where('P', states(getBoilerCasingState()))
                .where('A', air())
                .where(' ', any())
                .build();
    }

    private static IBlockState getCasingState() {
        return MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.ALUMINIUM_FROSTPROOF);
    }

    private static IBlockState getGlassState() {
        return MetaBlocks.TRANSPARENT_CASING.getState(BlockGlassCasing.CasingType.TEMPERED_GLASS);
    }

    private static IBlockState getSecondCasingState() {
        return MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.STAINLESS_CLEAN);
    }

    private static IBlockState getUniqueCasingState() {
        return GCYMMetaBlocks.UNIQUE_CASING.getState(BlockUniqueCasing.UniqueCasingType.HEAT_VENT);
    }

    private static IBlockState getBoilerCasingState() {
        return MetaBlocks.BOILER_CASING.getState(BlockBoilerCasing.BoilerCasingType.TUNGSTENSTEEL_PIPE);
    }

    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return Textures.FROST_PROOF_CASING;
    }

    @Nonnull
    @Override
    protected OrientedOverlayRenderer getFrontOverlay() {
        return GCYMTextures.MEGA_VACUUM_FREEZER_OVERLAY;
    }

    @Override
    public String[] getDescription() {
        List<String> list = new ArrayList<>();
        list.add(I18n.format("gcym.machine.mega_vacuum_freezer.description"));
        return list.toArray(new String[0]);
    }
}

package gregicality.multiblocks.common.metatileentities.multiblock.generator;

import java.util.ArrayList;
import java.util.List;

import gregtech.api.capability.GregtechCapabilities;
import gregtech.api.capability.IEnergyContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.jetbrains.annotations.Nullable;

import gregtech.api.GTValues;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.api.metatileentity.multiblock.FuelMultiblockController;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.pattern.BlockPattern;
import gregtech.api.pattern.FactoryBlockPattern;
import gregtech.api.recipes.RecipeMaps;
import gregtech.client.renderer.ICubeRenderer;
import gregtech.common.blocks.BlockTurbineCasing;
import gregtech.common.blocks.MetaBlocks;

import gregicality.multiblocks.api.render.GCYMTextures;
import gregicality.multiblocks.common.block.GCYMMetaBlocks;
import gregicality.multiblocks.common.block.blocks.BlockLargeMultiblockCasing;

import javax.annotation.Nonnull;

import static gregtech.api.GTValues.*;

public class MetaTileEntitySteamEngine extends FuelMultiblockController {

    public MetaTileEntitySteamEngine(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, RecipeMaps.STEAM_TURBINE_FUELS, GTValues.MV);
        this.recipeMapWorkable.setMaximumOverclockVoltage(V[MV]);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new MetaTileEntitySteamEngine(metaTileEntityId);
    }

    @Nonnull
    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("#XX", "XEX", "#XX")
                .aisle("XXX", "XGX", "XMX")
                .aisle("#XX", "XGX", "#XX")
                .aisle("#XX", "#SX", "#XX")
                .where('S', this.selfPredicate())
                .where('X', states(getCasingState())
                        .setMinGlobalLimited(18)
                        .or(autoAbilities(false, true, true, true, true, true, false)))
                .where('G', states(getSecondCasingState()))
                .where('E', states(getCasingState())
                        .or(metaTileEntities(MultiblockAbility.REGISTRY.get(MultiblockAbility.OUTPUT_ENERGY).stream()
                                .filter(mte -> {
                                    IEnergyContainer container = mte.getCapability(GregtechCapabilities.CAPABILITY_ENERGY_CONTAINER, null);
                                    return container != null && container.getOutputVoltage() == GTValues.V[MV]
                                            && container.getOutputAmperage() == 2;
                                })
                                .toArray(MetaTileEntity[]::new)).setExactLimit(1).setPreviewCount(1)))
                .where('M', abilities(MultiblockAbility.MUFFLER_HATCH))
                .where('#', any())
                .build();
    }

    private static IBlockState getCasingState() {
        return GCYMMetaBlocks.LARGE_MULTIBLOCK_CASING.getState(BlockLargeMultiblockCasing.CasingType.STEAM_CASING);
    }

    private static IBlockState getSecondCasingState() {
        return MetaBlocks.TURBINE_CASING.getState(BlockTurbineCasing.TurbineCasingType.BRONZE_GEARBOX);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World player, @Nonnull List<String> tooltip, boolean advanced) {
        super.addInformation(stack, player, tooltip, advanced);
        tooltip.add(I18n.format("gcym.machine.steam_engine.tooltip.1", GTValues.VNF[GTValues.MV]));
    }

    @Override
    public String[] getDescription() {
        List<String> list = new ArrayList<>();
        list.add(I18n.format("gcym.machine.steam_engine.description"));
        return list.toArray(new String[0]);
    }

    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart iMultiblockPart) {
        return GCYMTextures.STEAM_CASING;
    }

    @Nonnull
    @Override
    protected ICubeRenderer getFrontOverlay() {
        return GCYMTextures.STEAM_ENGINE_OVERLAY;
    }

    @Override
    public boolean hasMufflerMechanics() {
        return true;
    }

    @Override
    public void runMufflerEffect(float xPos, float yPos, float zPos, float xSpd, float ySpd, float zSpd) {
        this.getWorld().spawnParticle(EnumParticleTypes.CLOUD, xPos, yPos, zPos, xSpd, ySpd, zSpd);
    }
}

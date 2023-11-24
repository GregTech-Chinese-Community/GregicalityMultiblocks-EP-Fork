package gregicality.multiblocks.loaders.recipe;

import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.stack.UnificationEntry;
import gregtech.common.items.MetaItems;

import gregicality.multiblocks.common.block.GCYMMetaBlocks;
import gregicality.multiblocks.common.block.blocks.BlockLargeMultiblockCasing;
import gregicality.multiblocks.common.block.blocks.BlockUniqueCasing;

import static gregicality.multiblocks.api.unification.GCYMMaterials.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;

public final class GCYMCasingLoader {

    private GCYMCasingLoader() {}

    public static void init() {

        //  Multiblock Casings
        ModHandler.addShapedRecipe(true, "casing_large_macerator", GCYMMetaBlocks.LARGE_MULTIBLOCK_CASING.getItemVariant(BlockLargeMultiblockCasing.CasingType.MACERATOR_CASING, 2),
                "PhP", "PFP", "PwP",
                'P', new UnificationEntry(plate, Zeron100),
                'F', new UnificationEntry(frameGt, Titanium));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, Zeron100, 6)
                .input(frameGt, Titanium)
                .circuitMeta(6)
                .outputs(GCYMMetaBlocks.LARGE_MULTIBLOCK_CASING.getItemVariant(BlockLargeMultiblockCasing.CasingType.MACERATOR_CASING, 2))
                .duration(50)
                .EUt(16)
                .buildAndRegister();

        ModHandler.addShapedRecipe(true, "casing_high_temperature", GCYMMetaBlocks.LARGE_MULTIBLOCK_CASING.getItemVariant(BlockLargeMultiblockCasing.CasingType.HIGH_TEMPERATURE_CASING, 2),
                "DhD", "PFP", "DwD",
                'P', new UnificationEntry(plate, TitaniumCarbide),
                'D', new UnificationEntry(plate, HSLASteel),
                'F', new UnificationEntry(frameGt, TungstenCarbide));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, HSLASteel, 4)
                .input(plate, TitaniumCarbide, 2)
                .input(frameGt, TungstenCarbide)
                .circuitMeta(6)
                .outputs(GCYMMetaBlocks.LARGE_MULTIBLOCK_CASING.getItemVariant(BlockLargeMultiblockCasing.CasingType.HIGH_TEMPERATURE_CASING, 2))
                .duration(50)
                .EUt(16)
                .buildAndRegister();

        ModHandler.addShapedRecipe(true, "casing_large_assembler", GCYMMetaBlocks.LARGE_MULTIBLOCK_CASING.getItemVariant(BlockLargeMultiblockCasing.CasingType.ASSEMBLING_CASING, 2),
                "PhP", "PFP", "PwP",
                'P', new UnificationEntry(plate, Stellite100),
                'F', new UnificationEntry(frameGt, Tungsten));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, Stellite100, 6)
                .input(frameGt, Tungsten)
                .circuitMeta(6)
                .outputs(GCYMMetaBlocks.LARGE_MULTIBLOCK_CASING.getItemVariant(BlockLargeMultiblockCasing.CasingType.ASSEMBLING_CASING, 2))
                .duration(50)
                .EUt(16)
                .buildAndRegister();

        ModHandler.addShapedRecipe(true, "casing_stress_proof", GCYMMetaBlocks.LARGE_MULTIBLOCK_CASING.getItemVariant(BlockLargeMultiblockCasing.CasingType.STRESS_PROOF_CASING, 2),
                "PhP", "PFP", "PwP",
                'P', new UnificationEntry(plate, MaragingSteel300),
                'F', new UnificationEntry(frameGt, StainlessSteel));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, MaragingSteel300, 6)
                .input(frameGt, StainlessSteel)
                .circuitMeta(6)
                .outputs(GCYMMetaBlocks.LARGE_MULTIBLOCK_CASING.getItemVariant(BlockLargeMultiblockCasing.CasingType.STRESS_PROOF_CASING, 2))
                .duration(50)
                .EUt(16)
                .buildAndRegister();

        ModHandler.addShapedRecipe(true, "casing_corrosion_proof", GCYMMetaBlocks.LARGE_MULTIBLOCK_CASING.getItemVariant(BlockLargeMultiblockCasing.CasingType.CORROSION_PROOF_CASING, 2),
                "PhP", "PFP", "PwP",
                'P', new UnificationEntry(plate, CobaltBrass),
                'F', new UnificationEntry(frameGt, HSLASteel));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, CobaltBrass, 6)
                .input(frameGt, HSLASteel)
                .circuitMeta(6)
                .outputs(GCYMMetaBlocks.LARGE_MULTIBLOCK_CASING.getItemVariant(BlockLargeMultiblockCasing.CasingType.CORROSION_PROOF_CASING, 2))
                .duration(50)
                .EUt(16)
                .buildAndRegister();

        ModHandler.addShapedRecipe(true, "casing_vibration_safe", GCYMMetaBlocks.LARGE_MULTIBLOCK_CASING.getItemVariant(BlockLargeMultiblockCasing.CasingType.VIBRATION_SAFE_CASING, 2),
                "PhP", "PFP", "PwP",
                'P', new UnificationEntry(plate, IncoloyMA956),
                'F', new UnificationEntry(frameGt, IncoloyMA956));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, IncoloyMA956, 6)
                .input(frameGt, IncoloyMA956)
                .circuitMeta(6)
                .outputs(GCYMMetaBlocks.LARGE_MULTIBLOCK_CASING.getItemVariant(BlockLargeMultiblockCasing.CasingType.VIBRATION_SAFE_CASING, 2))
                .duration(50)
                .EUt(16)
                .buildAndRegister();

        ModHandler.addShapedRecipe(true, "casing_watertight", GCYMMetaBlocks.LARGE_MULTIBLOCK_CASING.getItemVariant(BlockLargeMultiblockCasing.CasingType.WATERTIGHT_CASING, 2),
                "PhP", "PFP", "PwP",
                'P', new UnificationEntry(plate, WatertightSteel),
                'F', new UnificationEntry(frameGt, WatertightSteel));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, WatertightSteel, 6)
                .input(frameGt, WatertightSteel)
                .circuitMeta(6)
                .outputs(GCYMMetaBlocks.LARGE_MULTIBLOCK_CASING.getItemVariant(BlockLargeMultiblockCasing.CasingType.WATERTIGHT_CASING, 2))
                .duration(50)
                .EUt(16)
                .buildAndRegister();

        ModHandler.addShapedRecipe(true, "casing_large_cutter", GCYMMetaBlocks.LARGE_MULTIBLOCK_CASING.getItemVariant(BlockLargeMultiblockCasing.CasingType.CUTTER_CASING, 2),
                "PhP", "PFP", "PwP",
                'P', new UnificationEntry(plate, HastelloyC276),
                'F', new UnificationEntry(frameGt, HastelloyC276));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, HastelloyC276, 6)
                .input(frameGt, HastelloyC276)
                .circuitMeta(6)
                .outputs(GCYMMetaBlocks.LARGE_MULTIBLOCK_CASING.getItemVariant(BlockLargeMultiblockCasing.CasingType.CUTTER_CASING, 2))
                .duration(50)
                .EUt(16)
                .buildAndRegister();

        ModHandler.addShapedRecipe(true, "casing_nonconducting", GCYMMetaBlocks.LARGE_MULTIBLOCK_CASING.getItemVariant(BlockLargeMultiblockCasing.CasingType.NONCONDUCTING_CASING, 2),
                "PhP", "PFP", "PwP",
                'P', new UnificationEntry(plate, HSLASteel),
                'F', new UnificationEntry(frameGt, HSLASteel));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, HSLASteel, 6)
                .input(frameGt, HSLASteel)
                .circuitMeta(6)
                .outputs(GCYMMetaBlocks.LARGE_MULTIBLOCK_CASING.getItemVariant(BlockLargeMultiblockCasing.CasingType.NONCONDUCTING_CASING, 2))
                .duration(50)
                .EUt(16)
                .buildAndRegister();

        ModHandler.addShapedRecipe(true, "casing_large_mixer", GCYMMetaBlocks.LARGE_MULTIBLOCK_CASING.getItemVariant(BlockLargeMultiblockCasing.CasingType.MIXER_CASING, 2),
                "PhP", "PFP", "PwP",
                'P', new UnificationEntry(plate, HastelloyX),
                'F', new UnificationEntry(frameGt, MaragingSteel300));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, HastelloyX, 6)
                .input(frameGt, MaragingSteel300)
                .circuitMeta(6)
                .outputs(GCYMMetaBlocks.LARGE_MULTIBLOCK_CASING.getItemVariant(BlockLargeMultiblockCasing.CasingType.MIXER_CASING, 2))
                .duration(50)
                .EUt(16)
                .buildAndRegister();

        ModHandler.addShapedRecipe(true, "casing_large_engraver", GCYMMetaBlocks.LARGE_MULTIBLOCK_CASING.getItemVariant(BlockLargeMultiblockCasing.CasingType.ENGRAVER_CASING, 2),
                "PhP", "PFP", "PwP",
                'P', new UnificationEntry(plate, TitaniumTungstenCarbide),
                'F', new UnificationEntry(frameGt, Titanium));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, TitaniumTungstenCarbide, 6)
                .input(frameGt, Titanium)
                .circuitMeta(6)
                .outputs(GCYMMetaBlocks.LARGE_MULTIBLOCK_CASING.getItemVariant(BlockLargeMultiblockCasing.CasingType.ENGRAVER_CASING, 2))
                .duration(50)
                .EUt(16)
                .buildAndRegister();

        ModHandler.addShapedRecipe(true, "casing_atomic", GCYMMetaBlocks.LARGE_MULTIBLOCK_CASING.getItemVariant(BlockLargeMultiblockCasing.CasingType.ATOMIC_CASING, 2),
                "PhP", "PFP", "PwP",
                'P', new UnificationEntry(plateDouble, Trinaquadalloy),
                'F', new UnificationEntry(frameGt, NaquadahAlloy));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plateDouble, Trinaquadalloy, 6)
                .input(frameGt, NaquadahAlloy)
                .circuitMeta(6)
                .outputs(GCYMMetaBlocks.LARGE_MULTIBLOCK_CASING.getItemVariant(BlockLargeMultiblockCasing.CasingType.ATOMIC_CASING, 2))
                .duration(50)
                .EUt(16)
                .buildAndRegister();

        ModHandler.addShapedRecipe(true, "casing_steam", GCYMMetaBlocks.LARGE_MULTIBLOCK_CASING.getItemVariant(BlockLargeMultiblockCasing.CasingType.STEAM_CASING, 2),
                "PhP", "PFP", "PwP",
                'P', new UnificationEntry(plate, Brass),
                'F', new UnificationEntry(frameGt, Brass));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, Brass, 6)
                .input(frameGt, Brass)
                .circuitMeta(6)
                .outputs(GCYMMetaBlocks.LARGE_MULTIBLOCK_CASING.getItemVariant(BlockLargeMultiblockCasing.CasingType.STEAM_CASING, 2))
                .duration(50)
                .EUt(16)
                .buildAndRegister();

        //  Unique Casings
        ModHandler.addShapedRecipe(true, "casing_crushing_wheels", GCYMMetaBlocks.UNIQUE_CASING.getItemVariant(BlockUniqueCasing.UniqueCasingType.CRUSHING_WHEELS, 2),
                "SSS", "GCG", "GMG",
                'S', new UnificationEntry(gearSmall, TungstenCarbide),
                'G', new UnificationEntry(gear, Ultimet),
                'C', GCYMMetaBlocks.LARGE_MULTIBLOCK_CASING.getItemVariant(BlockLargeMultiblockCasing.CasingType.MACERATOR_CASING),
                'M', MetaItems.ELECTRIC_MOTOR_IV.getStackForm());

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(gearSmall, TungstenCarbide, 3)
                .input(gear, Ultimet, 4)
                .inputs(MetaItems.ELECTRIC_MOTOR_IV.getStackForm())
                .inputs(GCYMMetaBlocks.LARGE_MULTIBLOCK_CASING.getItemVariant(BlockLargeMultiblockCasing.CasingType.MACERATOR_CASING))
                .outputs(GCYMMetaBlocks.UNIQUE_CASING.getItemVariant(BlockUniqueCasing.UniqueCasingType.CRUSHING_WHEELS, 2))
                .duration(50)
                .EUt(16)
                .buildAndRegister();

        ModHandler.addShapedRecipe(true, "casing_slicing_blades", GCYMMetaBlocks.UNIQUE_CASING.getItemVariant(BlockUniqueCasing.UniqueCasingType.SLICING_BLADES, 2),
                "SSS", "GCG", "GMG",
                'S', new UnificationEntry(plate, TungstenCarbide),
                'G', new UnificationEntry(gear, Ultimet),
                'C', GCYMMetaBlocks.LARGE_MULTIBLOCK_CASING.getItemVariant(BlockLargeMultiblockCasing.CasingType.CUTTER_CASING),
                'M', MetaItems.ELECTRIC_MOTOR_IV.getStackForm());

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, TungstenCarbide, 3)
                .input(gear, Ultimet, 4)
                .inputs(MetaItems.ELECTRIC_MOTOR_IV.getStackForm())
                .inputs(GCYMMetaBlocks.LARGE_MULTIBLOCK_CASING.getItemVariant(BlockLargeMultiblockCasing.CasingType.CUTTER_CASING))
                .outputs(GCYMMetaBlocks.UNIQUE_CASING.getItemVariant(BlockUniqueCasing.UniqueCasingType.SLICING_BLADES, 2))
                .duration(50)
                .EUt(16)
                .buildAndRegister();

        ModHandler.addShapedRecipe(true, "casing_electrolytic_cell", GCYMMetaBlocks.UNIQUE_CASING.getItemVariant(BlockUniqueCasing.UniqueCasingType.ELECTROLYTIC_CELL, 2),
                "WWW", "WCW", "KAK",
                'W', new UnificationEntry(wireGtDouble, Platinum),
                'C', GCYMMetaBlocks.LARGE_MULTIBLOCK_CASING.getItemVariant(BlockLargeMultiblockCasing.CasingType.NONCONDUCTING_CASING),
                'K', new UnificationEntry(circuit, MarkerMaterials.Tier.IV),
                'A', new UnificationEntry(cableGtSingle, Tungsten));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(wireGtDouble, Platinum, 5)
                .input(circuit, MarkerMaterials.Tier.IV, 2)
                .input(cableGtSingle, Tungsten)
                .inputs(GCYMMetaBlocks.LARGE_MULTIBLOCK_CASING.getItemVariant(BlockLargeMultiblockCasing.CasingType.NONCONDUCTING_CASING))
                .outputs(GCYMMetaBlocks.UNIQUE_CASING.getItemVariant(BlockUniqueCasing.UniqueCasingType.ELECTROLYTIC_CELL, 2))
                .duration(50)
                .EUt(16)
                .buildAndRegister();

        ModHandler.addShapedRecipe(true, "casing_heat_vent", GCYMMetaBlocks.UNIQUE_CASING.getItemVariant(BlockUniqueCasing.UniqueCasingType.HEAT_VENT, 2),
                "PDP", "RLR", "PDP",
                'P', new UnificationEntry(plate, TantalumCarbide),
                'D', new UnificationEntry(plateDouble, MolybdenumDisilicide),
                'R', new UnificationEntry(rotor, Titanium),
                'L', new UnificationEntry(stickLong, MolybdenumDisilicide));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, TantalumCarbide, 4)
                .input(rotor, Titanium, 2)
                .input(plateDouble, MolybdenumDisilicide, 2)
                .input(stickLong, MolybdenumDisilicide)
                .outputs(GCYMMetaBlocks.UNIQUE_CASING.getItemVariant(BlockUniqueCasing.UniqueCasingType.HEAT_VENT, 2))
                .duration(50)
                .EUt(16)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(ring, MolybdenumDisilicide, 32)
                .input(foil, Graphene, 16)
                .fluidInputs(HSLASteel.getFluid(L))
                .outputs(GCYMMetaBlocks.UNIQUE_CASING.getItemVariant(BlockUniqueCasing.UniqueCasingType.MOLYBDENUM_DISILICIDE_COIL))
                .duration(500)
                .EUt(VA[EV])
                .buildAndRegister();
    }
}

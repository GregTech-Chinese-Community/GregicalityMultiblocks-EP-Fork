package gregicality.multiblocks.api.unification;

import gregtech.api.GTValues;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.info.MaterialIconSet;
import gregtech.api.unification.material.properties.BlastProperty;

import static gregicality.multiblocks.api.unification.GCYMMaterials.*;
import static gregicality.multiblocks.api.utils.GCYMUtil.gcymId;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;
import static gregtech.api.unification.material.info.MaterialIconSet.*;
import static gregtech.api.util.GTUtility.*;

public class GCYMFirstDegreeMaterials {
    //  Range 3000-4000
    private static int startId = 3000;
    private static final int END_ID = startId + 500;

    public static void register() {
        //  3000 Stellite-100
        Stellite100 = new Material.Builder(getMaterialsId(), gregtechId("stellite_100"))
                .ingot()
                .fluid()
                .color(0xDEDEFF)
                .iconSet(BRIGHT)
                .flags(GENERATE_PLATE)
                .components(Iron, 4, Chrome, 3, Tungsten, 2, Molybdenum, 1)
                .blastTemp(3790, BlastProperty.GasTier.HIGH, GTValues.VA[GTValues.EV], 1000)
                .build();
        //  3001 Watertight Steel
        WatertightSteel = new Material.Builder(getMaterialsId(), gregtechId("watertight_steel"))
                .ingot()
                .fluid()
                .color(0x355D6A)
                .iconSet(METALLIC)
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_FRAME)
                .components(Iron, 7, Aluminium, 4, Nickel, 2, Chrome, 1, Sulfur, 1)
                .blastTemp(3850, BlastProperty.GasTier.MID, GTValues.VA[GTValues.EV], 800)
                .build();
        //  3002 Maraging Steel-300
        MaragingSteel300 = new Material.Builder(getMaterialsId(), gregtechId("maraging_steel_300"))
                .ingot()
                .fluid()
                .color(0x637087)
                .iconSet(METALLIC)
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_FRAME)
                .components(Iron, 16, Titanium, 1, Aluminium, 1, Nickel, 4, Cobalt, 2)
                .blastTemp(4000, BlastProperty.GasTier.HIGH, GTValues.VA[GTValues.EV], 1000)
                .build();
        //  3003 Hastelloy-C276
        HastelloyC276 = new Material.Builder(getMaterialsId(), gregtechId("hastelloy_c_276"))
                .ingot().fluid()
                .color(0xCF3939)
                .iconSet(METALLIC)
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_FRAME)
                .components(Nickel, 12, Molybdenum, 8, Chrome, 7, Tungsten, 1, Cobalt, 1, Copper, 1)
                .blastTemp(4625, BlastProperty.GasTier.MID)
                .build();
        //  3004 Hastelloy-X
        HastelloyX = new Material.Builder(getMaterialsId(), gregtechId("hastelloy_x"))
                .ingot()
                .fluid()
                .color(0x6BA3E3)
                .iconSet(METALLIC)
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_FRAME)
                .components(Nickel, 8, Iron, 3, Tungsten, 4, Molybdenum, 2, Chrome, 1, Niobium, 1)
                .blastTemp(4200, BlastProperty.GasTier.HIGH, GTValues.VA[GTValues.EV], 900)
                .build();
        //  3005 Trinaquadalloy
        Trinaquadalloy = new Material.Builder(getMaterialsId(), gregtechId("trinaquadalloy"))
                .ingot()
                .fluid()
                .color(0x281832)
                .iconSet(BRIGHT)
                .flags(GENERATE_PLATE, GENERATE_DOUBLE_PLATE)
                .components(Trinium, 6, Naquadah, 2, Carbon, 1)
                .blastTemp(8747, BlastProperty.GasTier.HIGHER, GTValues.VA[GTValues.ZPM], 1200)
                .build();
        //  3006 Zeron-100
        Zeron100 = new Material.Builder(getMaterialsId(), gregtechId("zeron_100"))
                .ingot()
                .fluid()
                .color(0x325A8C)
                .iconSet(METALLIC)
                .flags(GENERATE_PLATE)
                .components(Iron, 10, Nickel, 2, Tungsten, 2, Niobium, 1, Cobalt, 1)
                .blastTemp(3693, BlastProperty.GasTier.MID, GTValues.VA[GTValues.EV], 1000)
                .build();
        //  3007 Titanium Carbide
        TitaniumCarbide = new Material.Builder(getMaterialsId(), gregtechId("titanium_carbide"))
                .ingot()
                .fluid()
                .color(0xB20B3A)
                .iconSet(METALLIC)
                .flags(GENERATE_PLATE)
                .components(Titanium, 1, Carbon, 1)
                .blastTemp(3430, BlastProperty.GasTier.MID, GTValues.VA[GTValues.EV], 1000)
                .build();
        //  3008 Tantalum Carbide
        TantalumCarbide = new Material.Builder(getMaterialsId(), gregtechId("tantalum_carbide"))
                .ingot()
                .fluid()
                .color(0x56566A)
                .iconSet(METALLIC)
                .flags(GENERATE_PLATE, GENERATE_DENSE)
                .components(Tantalum, 1, Carbon, 1)
                .blastTemp(4120, BlastProperty.GasTier.MID, GTValues.VA[GTValues.EV], 1200)
                .build();
        //  3009 Molybdenum Disilicide
        MolybdenumDisilicide = new Material.Builder(getMaterialsId(), gregtechId("molybdenum_disilicide"))
                .ingot()
                .fluid()
                .color(0x6A5BA3)
                .iconSet(METALLIC)
                .flags(EXT_METAL, GENERATE_DOUBLE_PLATE, GENERATE_LONG_ROD, GENERATE_SPRING, GENERATE_RING)
                .components(Molybdenum, 1, Silicon, 2)
                .blastTemp(2300, BlastProperty.GasTier.MID, GTValues.VA[GTValues.EV], 800)
                .build();
        //  3010 HSLA Steel
        HSLASteel = new Material.Builder(getMaterialsId(), gregtechId("hsla_steel"))
                .ingot()
                .fluid()
                .color(0x808080)
                .iconSet(METALLIC)
                .flags(EXT_METAL, GENERATE_DOUBLE_PLATE, GENERATE_LONG_ROD, GENERATE_SPRING, GENERATE_FRAME)
                .components(Invar, 2, Vanadium, 1, Titanium, 1, Molybdenum, 1)
                .blastTemp(1711, BlastProperty.GasTier.LOW, GTValues.VA[GTValues.HV], 1000)
                .build();
        //  3011 Titanium Tungsten Carbide
        TitaniumTungstenCarbide = new Material.Builder(getMaterialsId(), gregtechId("titanium_tungsten_carbide"))
                .ingot()
                .fluid()
                .color(0x800D0D)
                .iconSet(METALLIC)
                .flags(GENERATE_PLATE)
                .components(TungstenCarbide, 1, TitaniumCarbide, 2)
                .blastTemp(3800, BlastProperty.GasTier.HIGH, GTValues.VA[GTValues.EV], 1000)
                .build();
        //  3012 Incoloy-MA956
        IncoloyMA956 = new Material.Builder(getMaterialsId(), gregtechId("incoloy_ma_956"))
                .ingot()
                .fluid()
                .color(0x37BF7E)
                .iconSet(METALLIC)
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_FRAME)
                .components(VanadiumSteel, 4, Manganese, 2, Aluminium, 5, Yttrium, 2)
                .blastTemp(3625, BlastProperty.GasTier.MID, GTValues.VA[GTValues.EV], 800)
                .build();
    }

    private static int getMaterialsId() {
        if (startId < END_ID) {
            return startId++;
        }
        throw new ArrayIndexOutOfBoundsException();
    }
}

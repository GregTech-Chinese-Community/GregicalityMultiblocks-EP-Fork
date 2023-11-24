package gregicality.multiblocks.api.unification;

import gregtech.api.unification.material.Material;

public final class GCYMMaterials {

    public static Material Stellite100;
    public static Material WatertightSteel;
    public static Material MaragingSteel300;
    public static Material HastelloyC276;
    public static Material HastelloyX;
    public static Material Trinaquadalloy;
    public static Material Zeron100;
    public static Material TitaniumCarbide;
    public static Material TantalumCarbide;
    public static Material MolybdenumDisilicide;
    public static Material HSLASteel;
    public static Material TitaniumTungstenCarbide;
    public static Material IncoloyMA956;

    //  Range: 3000-3500
    public static void init() {
        GCYMFirstDegreeMaterials.register();
        GCYMMaterialFlagAddition.init();
    }
}

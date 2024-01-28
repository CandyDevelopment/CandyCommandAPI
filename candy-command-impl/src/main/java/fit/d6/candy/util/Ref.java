package fit.d6.candy.util;

import org.bukkit.Bukkit;

public final class Ref {

    public static boolean isOldNms() {
        return switch (getObcVersion()) {
            case "_1_7_R1",
                    "_1_7_R2",
                    "_1_7_R3",
                    "_1_7_R4",
                    "1_8_R1",
                    "1_8_R2",
                    "1_8_R3",
                    "1_8_R4",
                    "1_9_R1",
                    "1_9_R2",
                    "1_9_R3",
                    "1_9_R4",
                    "1_10_R1",
                    "1_10_R2",
                    "1_10_R3",
                    "1_11_R1",
                    "1_11_R2",
                    "1_11_R3",
                    "1_12_R1",
                    "1_12_R2",
                    "1_12_R3",
                    "1_13_R1",
                    "1_13_R2",
                    "1_13_R3",
                    "1_14_R1",
                    "1_14_R2",
                    "1_14_R3",
                    "1_14_R4",
                    "1_15_R1",
                    "1_15_R2",
                    "1_15_R3",
                    "1_16_R1",
                    "1_16_R2",
                    "1_16_R3",
                    "1_16_R4",
                    "1_16_R5" -> true;
            default -> false;
        };
    }

    public static String getObcVersion() {
        return Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3].substring(1);
    }

    private Ref() {

    }

}

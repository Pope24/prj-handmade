package com.migration;

import com.enums.EProductType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductTypeMigration {
    public static List<String> getAllProductType() {
        List<String> productTypes = new ArrayList<>();
        for (EProductType type : EProductType.values())
            switch (type) {
                case DECORATION:
                case LEATHER:
                case FABRIC:
                case JEWELRY:
                case COSMETIC:
                case GIFT:
                    productTypes.add(type.name());
                    break;
                case DAILY_SUPPLIES:
                    productTypes.add("DAILY SUPPLIES");
                    break;
            }
        return productTypes;
    }

    public static int getIdProductTypeByName(String name) {
        for (EProductType type : EProductType.values()) {
            if (name.toLowerCase().equals(type.name().toLowerCase())) {
                return type.ordinal();
            }
        }
        return -1;
    }

    public static EProductType getEnumTypeById(int id) {
        for (EProductType type : EProductType.values()) {
            if (type.ordinal() == id) {
                return type;
            }
        }
        return null;
    }

    public static String getNameProductTypeByEnum(EProductType type) {
        try {
            switch (type) {
                case DECORATION:
                    return "Decoration";
                case LEATHER:
                    return "Leather";
                case FABRIC:
                    return "Fabric";
                case JEWELRY:
                    return "Jewelry";
                case COSMETIC:
                    return "Cosmetic";
                case GIFT:
                    return "Gift";
                case DAILY_SUPPLIES:
                    return "Daily supplies";
            }
        } catch (NullPointerException e) {
            return "";
        }
        return "";
    }
    public static String getNameProductTypeById(int id) {
        return getNameProductTypeByEnum(getEnumTypeById(id));
    }
    public static String[] getArrayIntAllType() {
        EProductType[] types = EProductType.values();
        String[] res = new String[types.length];
        for (int i = 0; i < types.length; i++) {
            res[i] = String.valueOf(types[i].ordinal());
        }
        return res;
    }
}

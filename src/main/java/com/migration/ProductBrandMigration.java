package com.migration;

import com.enums.EProductBrand;
import com.enums.EProductType;

import java.util.ArrayList;
import java.util.List;

public class ProductBrandMigration {
    public static List<String> getAllProductBrand() {
        List<String> productBrands = new ArrayList<>();
        for (EProductBrand brand: EProductBrand.values())
            switch (brand) {
                case VINTAGE:
                case OLUG:
                case CINCINATI:
                case DESINO:
                case PONAGAR:
                case LEONARDO:
                    productBrands.add(brand.name());
                    break;
                case NEYUH_LEATHER:
                    productBrands.add("NEYUH LEATHER");
                    break;
            }
        return productBrands;
    }
    public static int getIdProductBrandByName(String name) {
        for (EProductBrand brand: EProductBrand.values()) {
            if (name.toLowerCase().equals(brand.name().toLowerCase())) {
                return brand.ordinal();
            }
        }
        return -1;
    }
    public static EProductBrand getEnumBrandById(int id) {
        for (EProductBrand brand : EProductBrand.values()) {
            if (brand.ordinal() == id) {
                return brand;
            }
        }
        return null;
    }

    public static String getNameProductBrandByEnum(EProductBrand brand) {
        try {
            switch (brand) {
                case VINTAGE:
                    return "Vintage";
                case OLUG:
                    return "Olug";
                case CINCINATI:
                    return "Cincinati";
                case NEYUH_LEATHER:
                    return "Neyuh Leather";
                case DESINO:
                    return "Desino";
                case PONAGAR:
                    return "Ponagar";
                case LEONARDO:
                    return "Leonardo";
            }
        } catch (NullPointerException e) {
            return "";
        }
        return "";
    }

    public static String getNameProductBrandById(int pBrand) {
        return getNameProductBrandByEnum(getEnumBrandById(pBrand));
    }
}

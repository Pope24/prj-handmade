package com.migration;

import com.enums.EGender;

public class GenderMigration {
    public static int genderConvertInt(EGender eGender) {
        return eGender.ordinal();
    }
    public static EGender numberConvertGender(int gender) {
        switch (gender) {
            case 1:
                return EGender.MALE;
            case 2:
                return EGender.FEMALE;
            case 3:
                return EGender.OTHER;
        }
        return null;
    }
}

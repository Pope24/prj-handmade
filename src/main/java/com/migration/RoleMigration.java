package com.migration;

import com.enums.ERole;

public class RoleMigration {
    public static int genderConvertInt(ERole eRole) {
        return eRole.ordinal();
    }
    public static ERole numberConvertGender(int gender) {
        switch (gender) {
            case 1:
                return ERole.ADMIN;
            case 2:
                return ERole.SUPPLIER;
            case 3:
                return ERole.USER;
        }
        return null;
    }
}

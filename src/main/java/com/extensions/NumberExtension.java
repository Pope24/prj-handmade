package com.extensions;

import java.math.BigDecimal;

public class NumberExtension {
    public static BigDecimal convertStringToMoney(String sMoney) {
        sMoney = sMoney.replace(".", "");
        sMoney = sMoney.replace(" VND", "");
        return new BigDecimal(sMoney);
    }
}

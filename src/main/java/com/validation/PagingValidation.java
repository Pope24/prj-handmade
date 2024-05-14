package com.validation;

public class PagingValidation {
    public static int checkPageAndReturn1IfNotTrue(String page) {
        int res;
        try {
            res = Integer.parseInt(page);
        } catch (NumberFormatException e) {
            return 1;
        }
        return res;
    }
}

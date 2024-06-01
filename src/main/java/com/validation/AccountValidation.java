package com.validation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.LinkedHashMap;
import java.util.Map;

public class AccountValidation {
    public static Map<String, String> checkChangePassword(String newPassword, String confirmPassword, String code, HttpServletRequest request) {
        Map<String, String> errors = new LinkedHashMap<>();
        if (!newPassword.equals(confirmPassword)) {
            errors.put("errorConfirmPassword", "Xác minh mật khẩu không đúng.");
        }
        HttpSession session = request.getSession(true);
        String verifyCode = String.valueOf(session.getAttribute("code"));
        if (!code.equals(verifyCode)) {
            errors.put("errorVerifyCode", "Mã code không hợp lệ.");
        }
        return errors;
    }
    public static boolean checkPassword(String password) {
        if (password.trim().length() >= 6) {
            return true;
        }
        return false;
    }
    public static boolean checkUsername(String username) {
        if (username.trim().length() >= 6) {
            return true;
        }
        return false;
    }
}

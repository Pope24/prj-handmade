package com.validation;

import com.repository.UserRepository;
import com.repository.impl.IUserRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidation {
    private static IUserRepository userRepository = new UserRepository();
    public static boolean validateEmailUser(String email) {
        String regexPattern = "^(.+)@(\\S+)$";
        return Pattern.compile(regexPattern)
                .matcher(email)
                .matches();
    }
    public static boolean validatePhoneNumber(String phoneNumber) {
        Pattern pattern = Pattern.compile("^0[0-9]{9,10}$");
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }
    public static boolean validateCccd(String cccd) {
        String regexPattern = "\\d{12}";
        return Pattern.compile(regexPattern)
                .matcher(cccd)
                .matches();
    }
    public static boolean checkDOB(String dob) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate parsedDate = LocalDate.parse(dob, formatter);
            LocalDate currentDate = LocalDate.now();
            if (parsedDate.isBefore(currentDate)) {
                return true;
            }
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Please use dd/MM/yyyy.");
            return false;
        }
        return false;
    }
    public static boolean checkExistEmailUser(String email) {
        if (userRepository.getUserByEmail(email) == null) {
            return false;
        }
        return true;
    }
    public static boolean checkExistPhoneNumberUser(String phone) {
        if (userRepository.getUserByPhoneNumber(phone) == null) {
            return false;
        }
        return true;
    }
}

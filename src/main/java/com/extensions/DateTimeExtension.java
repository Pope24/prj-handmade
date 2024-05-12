package com.extensions;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeExtension {
    public static LocalDate convertStringDateTimeToLocalDate(String s) {
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");

        LocalDateTime localDateTime = LocalDateTime.parse(s, inputFormatter);

        LocalDate localDate = localDateTime.toLocalDate();

        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = localDate.format(outputFormatter);
        return LocalDate.parse(formattedDate, outputFormatter);
    }
}

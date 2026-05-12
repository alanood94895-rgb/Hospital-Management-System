package Utils;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;
import java.util.UUID;

public class HelperUtils {


    // NULL CHECK METHODS

    public static Boolean isNull(Object obj) {
        return obj == null;
    }

    public static Boolean isNull(String str) {
        return str == null || str.trim().isEmpty();
    }

    public static Boolean isNotNull(Object obj) {
        return obj != null;
    }

    public static Boolean isNotNull(String str) {
        return str != null && !str.trim().isEmpty();
    }

    // STRING VALIDATION

    public static boolean isValidString(String str) {
        return str != null && !str.trim().isEmpty();
    }

    public static boolean isValidString(String str, int minLength) {
        return str != null && str.length() >= minLength;
    }

    public static boolean isValidString(String str, int minLength, int maxLength) {
        return str != null && str.length() >= minLength && str.length() <= maxLength;
    }

    public static boolean isValidString(String str, String regex) {
        return str != null && str.matches(regex);
    }


    // Id Generation
    public static UUID generateId() {
        return UUID.randomUUID();
    }

    public static String generateId(String prefix) {
        return prefix + UUID.randomUUID();
    }

    public static String generateId(String prefix, int length) {
        return prefix + UUID.randomUUID().toString().substring(0, length);
    }

    public static String generateId(String prefix, String suffix) {
        return prefix + UUID.randomUUID() + suffix;
    }


    // DATE VALIDATION (LOCALDATE ONLY)

    public static Boolean isValidDate(String dateStr) {
        if (dateStr == null || dateStr.isEmpty()) {
            return false;
        }

        try {
            LocalDate.parse(dateStr);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public static Boolean isFutureDate(LocalDate date) {
        return date != null && date.isAfter(LocalDate.now());
    }

    public static Boolean isPastDate(LocalDate date) {
        return date != null && date.isBefore(LocalDate.now());
    }

    public static Boolean isToday(LocalDate date) {
        return date != null && date.equals(LocalDate.now());
    }

    // NUMERIC VALIDATION


    public static Boolean isValidNumber(int num, int min, int max) {
        return num >= min && num <= max;
    }

    public static Boolean isValidNumber(double num, double min, double max) {
        return num >= min && num <= max;
    }

    public static Boolean isPositive(int num) {
        return num > 0;
    }

    public static Boolean isPositive(double num) {
        return num > 0;
    }

    public static Boolean isNegative(int num) {
        return num < 0;
    }

    public static Boolean isNegative(double num) {
        return num < 0;
    }


    // AGE VALIDATION


    public static boolean isValidAge(int age) {
        return age >= 0 && age <= 120;
    }

    public static boolean isValidAge(LocalDate dateOfBirth) {
        if (dateOfBirth == null) {
            return false;
        }

        int age = Period.between(dateOfBirth, LocalDate.now()).getYears();
        return age >= 0 && age <= 120;
    }
}
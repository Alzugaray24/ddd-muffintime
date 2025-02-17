package com.buildingblocks.shared.domain.utils;

import java.util.Objects;

public class ValidationUtils {

    public static void validateTextNotEmpty(String text, String message) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void validateNumberNotNull(Integer number, String message) {
        if (number == null) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void validateNumberNotNegative(Integer number, String message) {
        if (number < 0) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void validateBoolean(Boolean value, String errorMessage) {
        if (Objects.isNull(value)) {
            throw new IllegalArgumentException(errorMessage);
        }
    }



}


package lotto.util;

import java.util.regex.Pattern;

import static lotto.exception.ExceptionMessage.INVALID_NUMBER;

public class IntegerParser {

    private IntegerParser() {
    }

    private static final Pattern REGEX = Pattern.compile("^[1-9]\\d*$");

    public static int convertToInt(String input) {
        validateNumber(input);
        return Integer.parseInt(input);
    }

    //todo int 범위 넘었을시
    private static void validateNumber(String input) {
        if (isNotNumber(input)) {
            throw new IllegalArgumentException(INVALID_NUMBER.getMessage());
        }
    }

    private static boolean isNotNumber(String input) {
        return !REGEX.matcher(input).find();
    }
}

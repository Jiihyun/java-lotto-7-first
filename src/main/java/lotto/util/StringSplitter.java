package lotto.util;

import java.util.Arrays;
import java.util.List;

public class StringSplitter {

    private static final String DELEMITER = ",";

    public static List<String> splitByDelimiter(String input) {
        return Arrays.asList(input.split(DELEMITER));
    }
}

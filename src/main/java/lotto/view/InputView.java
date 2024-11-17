package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.IntegerParser;
import lotto.util.StringSplitter;

import java.util.List;
import java.util.regex.Pattern;

import static lotto.exception.ExceptionMessage.INPUT_BLANK;
import static lotto.exception.ExceptionMessage.INVALID_WINNING_NUMBER_FORMAT;

public class InputView {

    private static final Pattern WINNING_NUMBERS_FORMAT = Pattern.compile("\\d,\\d,\\d,\\d,\\d,\\d");
    public static final String NEW_LINE = System.lineSeparator();
    private static final String INPUT_MONEY_MSG = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS_MSG = NEW_LINE + "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MSG = NEW_LINE + "보너스 번호를 입력해 주세요.";

    public int readMoney() {
        String input = getValidatedInput(INPUT_MONEY_MSG);
        return IntegerParser.convertToInt(input);
    }

    public List<Integer> readWinningNumbers() {
        String input = getValidatedInput(INPUT_WINNING_NUMBERS_MSG);
        validateWinningNumbersFormat(input);

        return StringSplitter.splitByDelimiter(input)
                .stream()
                .map(IntegerParser::convertToInt)
                .toList();
    }

    public int readBonusNumber() {
        String input = getValidatedInput(INPUT_BONUS_NUMBER_MSG);
        return IntegerParser.convertToInt(input);
    }

    private String getValidatedInput(String message) {
        System.out.println(message);
        String input = Console.readLine().strip();
        validateInput(input);
        return input;
    }

    private void validateInput(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(INPUT_BLANK.getMessage());
        }
    }

    private void validateWinningNumbersFormat(String input) {
        if (!WINNING_NUMBERS_FORMAT.matcher(input).find()) {
            throw new IllegalArgumentException(INVALID_WINNING_NUMBER_FORMAT.getMessage());
        }
    }
}

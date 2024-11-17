package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.IntegerParser;

import static lotto.exception.ExceptionMessage.INPUT_BLANK;

public class InputView {

    private static final String INPUT_MONEY_MSG = "구입금액을 입력해 주세요.";

    public int readMoney() {
        String input = getValidatedInput(INPUT_MONEY_MSG);
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
}

package lotto.domain;

import static lotto.exception.ExceptionMessage.LOTTO_NUMBER_OUT_OF_RANGE;

public class LottoNumber {

    public static final int MIN_RANGE = 1;
    public static final int MAX_RANGE = 45;
    private final int number;

    public LottoNumber(int number) {
        validateNumberRange(number);
        this.number = number;
    }

    private void validateNumberRange(int number) {
        if (number < MIN_RANGE || number > MAX_RANGE) {
            throw new IllegalArgumentException(LOTTO_NUMBER_OUT_OF_RANGE.getMessage());
        }
    }

    public int getNumber() {
        return number;
    }
}

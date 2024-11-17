package lotto.exception;

import static java.lang.String.format;
import static lotto.domain.Lotto.LOTTO_SIZE;
import static lotto.domain.LottoNumber.MAX_RANGE;
import static lotto.domain.LottoNumber.MIN_RANGE;
import static lotto.domain.LottoStore.MAX_AMOUNT;
import static lotto.domain.LottoStore.PURCHASE_UNIT;

public enum ExceptionMessage {

    INPUT_BLANK("빈 값을 입력하셨습니다."),

    INVALID_NUMBER("유효하지 않은 숫자입니다."),

    DUPLICATED_LOTTO_NUMBERS("중복된 로또 번호들이 존재합니다"),

    INVALID_WINNING_NUMBER_FORMAT("유효하지 않은 당첨번호 형식입니다."),

    WRONG_PURCHASE_UNIT(
            format("%d원 단위로 구매 가능합니다.", PURCHASE_UNIT)
    ),
    AMOUNT_OUT_OF_RANGE(
            format("최소 %d원, 최대 %d원까지 구매 가능합니다.",
                    PURCHASE_UNIT,
                    MAX_AMOUNT)
    ),
    LOTTO_NUMBER_OUT_OF_RANGE(
            format("최소 %d, 최대 %d범위 내의 숫자여야 합니다.",
                    MIN_RANGE,
                    MAX_RANGE)
    ),
    WRONG_LOTTO_SIZE(
            format("로또 숫자는 총 %d개여야 합니다.", LOTTO_SIZE)
    ),

    ;

    private static final String ERROR_PREFIX = "[ERROR] ";

    private final String message;

    ExceptionMessage(String message) {
        this.message = ERROR_PREFIX + message;
    }

    public String getMessage() {
        return format(message);
    }
}

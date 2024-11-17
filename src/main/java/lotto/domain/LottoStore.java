package lotto.domain;

import static lotto.exception.ExceptionMessage.AMOUNT_OUT_OF_RANGE;
import static lotto.exception.ExceptionMessage.WRONG_PURCHASE_UNIT;

public class LottoStore {

    public static final int PURCHASE_UNIT = 1_000;
    public static final int MAX_AMOUNT = 100_000;

    public int calculatePurchasedLottoQuantity(int money) {
        validateAmountRange(money);
        validatePurchaseUnit(money);
        return money / PURCHASE_UNIT;
    }

    private void validatePurchaseUnit(int money) {
        if (money % PURCHASE_UNIT != 0) {
            throw new IllegalArgumentException(WRONG_PURCHASE_UNIT.getMessage());
        }
    }

    private void validateAmountRange(int money) {
        if (money < PURCHASE_UNIT || money > MAX_AMOUNT) {
            throw new IllegalArgumentException(AMOUNT_OUT_OF_RANGE.getMessage());
        }
    }
}

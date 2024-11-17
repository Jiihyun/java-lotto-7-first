package lotto.domain;

import static lotto.exception.ExceptionMessage.DUPLICATED_LOTTO_NUMBERS;

public class WinningNumbers {

    private final Lotto winningNumber;
    private final LottoNumber bonusNumber;

    public WinningNumbers(Lotto winningNumber, LottoNumber bonusNumber) {
        validateDuplicated(winningNumber, bonusNumber);
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicated(Lotto winningNumber, LottoNumber bonusNumber) {
        if (winningNumber.hasBonusNumber(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATED_LOTTO_NUMBERS.getMessage());
        }
    }
}

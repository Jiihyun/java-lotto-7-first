package lotto.domain;

import java.util.List;

import static lotto.exception.ExceptionMessage.DUPLICATED_LOTTO_NUMBERS;
import static lotto.exception.ExceptionMessage.WRONG_LOTTO_SIZE;

public class Lotto {

    public static final int LOTTO_SIZE = 6;

    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        validateLottoSize(numbers);
        validateDuplicateNumbers(numbers);
        this.numbers = convertToLottoNumber(numbers);
    }

    private void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(WRONG_LOTTO_SIZE.getMessage());
        }
    }

    private void validateDuplicateNumbers(List<Integer> numbers) {
        if (hasDuplicatedNumbers(numbers)) {
            throw new IllegalArgumentException(DUPLICATED_LOTTO_NUMBERS.getMessage());
        }
    }

    private boolean hasDuplicatedNumbers(List<Integer> numbers) {
        return numbers.size() != numbers.stream()
                .distinct()
                .count();
    }

    private List<LottoNumber> convertToLottoNumber(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .map(LottoNumber::new)
                .toList();
    }

    //TODO: 출력타입 고치기
    public List<Integer> getNumbers() {
        return numbers.stream()
                .map(LottoNumber::getNumber)
                .toList();
    }

    public boolean hasBonusNumber(LottoNumber number) {
        return numbers.contains(number);
    }
}

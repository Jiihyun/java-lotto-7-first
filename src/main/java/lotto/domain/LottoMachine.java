package lotto.domain;

import java.util.List;

public class LottoMachine {

    private final NumberGenerator numberGenerator;

    public LottoMachine(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public Lotto generateLotto() {
        List<Integer> numbers = numberGenerator.generateNumbers();
        return new Lotto(numbers);
    }
}

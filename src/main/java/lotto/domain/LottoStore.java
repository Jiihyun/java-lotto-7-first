package lotto.domain;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import static lotto.exception.ExceptionMessage.AMOUNT_OUT_OF_RANGE;
import static lotto.exception.ExceptionMessage.WRONG_PURCHASE_UNIT;

public class LottoStore {

    public static final int PURCHASE_UNIT = 1_000;
    public static final int MAX_AMOUNT = 100_000;

    private final LottoMachine lottoMachine;

    public LottoStore(LottoMachine lottoMachine) {
        this.lottoMachine = lottoMachine;
    }

    public Lottos purchaseLotto(int money) {
        int quantity = calculatePurchasedLottoQuantity(money);
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            lottos.add(lottoMachine.generateLotto());
        }
        return new Lottos(lottos);

    }

    public Map<Ranking, Integer> draw(WinningNumbers winningNumbers, Lottos lottos) {
        Map<Ranking, Integer> statistics = initStatistics();

        lottos.getLottos()
                .forEach(lotto -> {
                    int matchingCount = lotto.calculateMatchingCount(winningNumbers.getWinningNumber());
                    boolean hasBonusNumber = lotto.hasBonusNumber(winningNumbers.getBonusNumber());
                    Ranking rank = Ranking.drawResult(matchingCount, hasBonusNumber);
                    statistics.put(rank, statistics.get(rank) + 1);
                });
        return statistics;
    }

    private int calculatePurchasedLottoQuantity(int money) {
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

    private Map<Ranking, Integer> initStatistics() {
        Map<Ranking, Integer> statistics = new EnumMap<>(Ranking.class);
        for (Ranking rank : Ranking.values()) {
            statistics.put(rank, 0);
        }
        return statistics;
    }
}

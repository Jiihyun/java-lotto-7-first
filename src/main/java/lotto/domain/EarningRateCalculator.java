package lotto.domain;

import java.util.Map;

import static lotto.domain.LottoStore.PURCHASE_UNIT;

public class EarningRateCalculator {


    public double calculate(Map<Ranking, Integer> statistics, Lottos lottos) {
        double totalPrizeAmount = 0;
        int purchasedAmount = lottos.getQuantity() * PURCHASE_UNIT;
        for (Map.Entry<Ranking, Integer> rank : statistics.entrySet()) {
            totalPrizeAmount += rank.getKey().getPrizeAmount() * rank.getValue();
        }
        return (totalPrizeAmount / purchasedAmount) * 100;
    }
}

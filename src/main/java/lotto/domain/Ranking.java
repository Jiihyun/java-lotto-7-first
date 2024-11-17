package lotto.domain;

import java.util.Arrays;
import java.util.List;

public enum Ranking {

    NONE(0, 0, false),
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    ;

    private static final List<Ranking> rankingWithoutSecond = Arrays.asList(NONE, FIRST, THIRD, FOURTH, FIFTH);

    private final int matchingCount;
    private final int prizeAmount;
    private final boolean shouldHaveBonusNumber;

    Ranking(int matchingCount, int prizeAmount, boolean shouldHaveBonusNumber) {
        this.matchingCount = matchingCount;
        this.prizeAmount = prizeAmount;
        this.shouldHaveBonusNumber = shouldHaveBonusNumber;
    }

    public static Ranking drawResult(int matchingCount, boolean hasBonusNumber) {
        if (matchingCount == SECOND.matchingCount && hasBonusNumber) {
            return SECOND;
        }
        return rankingWithoutSecond.stream()
                .filter(ranking -> ranking.matchingCount == matchingCount)
                .findFirst()
                .orElse(NONE);
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }
}

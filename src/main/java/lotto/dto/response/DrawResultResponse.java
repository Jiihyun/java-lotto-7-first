package lotto.dto.response;

public record DrawResultResponse(
        int matchedThreeCount,
        int matchedFourCount,
        int matchedFiveCount,
        int matchedFiveAndBonusCount,
        int matchedSixCount,
        double earningRate
) {
}

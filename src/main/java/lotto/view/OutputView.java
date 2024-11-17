package lotto.view;

import lotto.domain.Lottos;
import lotto.dto.response.DrawResultResponse;

public class OutputView {

    public static final String NEW_LINE = System.lineSeparator();
    private static final String PURCHASED_LOTTO_MSG = "%d개를 구매했습니다.";
    private static final String DRAW_RESULT_MSG = """
            
            당첨 통계
            ---
            3개 일치 (5,000원) - %d개
            4개 일치 (50,000원) - %d개
            5개 일치 (1,500,000원) - %d개
            5개 일치, 보너스 볼 일치 (30,000,000원) - %d개
            6개 일치 (2,000,000,000원) - %d개
            총 수익률은 %,.1f%%입니다.
            """;

    public void printError(String error) {
        System.out.println(error);
    }

    public void printPurchasedLottos(Lottos lottos) {
        System.out.printf(NEW_LINE
                        + PURCHASED_LOTTO_MSG
                        + NEW_LINE,
                lottos.getQuantity());
        lottos.getLottos()
                .forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public void printDrawResult(DrawResultResponse drawResultResponse) {
        System.out.printf(DRAW_RESULT_MSG,
                drawResultResponse.matchedThreeCount(),
                drawResultResponse.matchedFourCount(),
                drawResultResponse.matchedFiveCount(),
                drawResultResponse.matchedFiveAndBonusCount(),
                drawResultResponse.matchedSixCount(),
                drawResultResponse.earningRate());
    }
}

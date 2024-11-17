package lotto.view;

import lotto.domain.Lottos;

public class OutputView {

    public static final String NEW_LINE = System.lineSeparator();
    private static final String PURCHASED_LOTTO_MSG = "%d개를 구매했습니다.";


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
}

package lotto.controller;

import lotto.domain.Lottos;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.function.Supplier;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController(InputView inputView, OutputView outputView, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void run() {
        int money = inputView.readMoney();
        Lottos lottos = lottoService.purchaseLotto(money);
        outputView.printPurchasedLottos(lottos);


    }

    private <T> T retryOnInvalidInput(Supplier<T> input) {
        while (true) {
            try {
                return input.get();
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }
}

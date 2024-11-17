package lotto.controller;

import lotto.domain.Lottos;
import lotto.dto.response.DrawResultResponse;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
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
        Lottos lottos = retryOnInvalidInput(this::purchaseLotto);
        draw(lottos);
    }

    private Lottos purchaseLotto() {
        int money = inputView.readMoney();
        Lottos lottos = lottoService.purchaseLotto(money);
        outputView.printPurchasedLottos(lottos);
        return lottos;
    }

    private void draw(Lottos lottos) {
        List<Integer> winningNumber = retryOnInvalidInput(inputView::readWinningNumber);
        int bonusNumber = retryOnInvalidInput(inputView::readBonusNumber);
        DrawResultResponse drawResultResponse = lottoService.draw(winningNumber, bonusNumber, lottos);
        outputView.printDrawResult(drawResultResponse);
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

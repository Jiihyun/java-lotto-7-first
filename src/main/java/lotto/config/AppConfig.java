package lotto.config;

import lotto.controller.LottoController;
import lotto.domain.AutoNumberGenerator;
import lotto.domain.EarningRateCalculator;
import lotto.domain.LottoMachine;
import lotto.domain.LottoStore;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class AppConfig {

    public LottoController controller() {
        return new LottoController(
                new InputView(),
                new OutputView(),
                lottoService()
        );
    }

    public LottoService lottoService() {
        return new LottoService(lottoStore(),
                new EarningRateCalculator());
    }

    public LottoStore lottoStore() {
        return new LottoStore(lottoMachine());
    }

    public LottoMachine lottoMachine() {
        return new LottoMachine(new AutoNumberGenerator());
    }
}

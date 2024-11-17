package lotto.service;

import lotto.domain.EarningRateCalculator;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoStore;
import lotto.domain.Lottos;
import lotto.domain.Ranking;
import lotto.domain.WinningNumbers;
import lotto.dto.response.DrawResultResponse;

import java.util.List;
import java.util.Map;

import static lotto.domain.Ranking.FIFTH;
import static lotto.domain.Ranking.FIRST;
import static lotto.domain.Ranking.FOURTH;
import static lotto.domain.Ranking.SECOND;
import static lotto.domain.Ranking.THIRD;

public class LottoService {

    private final LottoStore lottoStore;

    private final EarningRateCalculator earningRateCalculator;

    public LottoService(LottoStore lottoStore, EarningRateCalculator earningRateCalculator) {
        this.lottoStore = lottoStore;
        this.earningRateCalculator = earningRateCalculator;
    }

    public Lottos purchaseLotto(int money) {
        return lottoStore.purchaseLotto(money);
    }

    public DrawResultResponse draw(List<Integer> winningNumber, int bonusNumber, Lottos lottos) {
        Lotto wrappedWinningLotto = new Lotto(winningNumber);
        LottoNumber wrappedBonusNumber = new LottoNumber(bonusNumber);
        WinningNumbers winningNumbers = new WinningNumbers(wrappedWinningLotto, wrappedBonusNumber);

        Map<Ranking, Integer> statistics = lottoStore.draw(winningNumbers, lottos);
        double earningRate = earningRateCalculator.calculate(statistics, lottos);
        return new DrawResultResponse(statistics.get(FIFTH),
                statistics.get(FOURTH),
                statistics.get(THIRD),
                statistics.get(SECOND),
                statistics.get(FIRST),
                earningRate
        );
    }
}

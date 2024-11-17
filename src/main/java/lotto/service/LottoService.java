package lotto.service;

import lotto.domain.LottoStore;
import lotto.domain.Lottos;

public class LottoService {

    private final LottoStore lottoStore;

    public LottoService(LottoStore lottoStore) {
        this.lottoStore = lottoStore;
    }

    public Lottos purchaseLotto(int money) {
        return lottoStore.purchaseLotto(money);
    }
}

package lotto.domain;

import lombok.Getter;
import lotto.domain.dto.ManualLottoNumberInputDTO;
import lotto.parser.LottoParser;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoSet {

    @Getter
    private final Set<Lotto> lottoSet;

    public LottoSet(Set<Lotto> lottoSet) {
        this.lottoSet = lottoSet;
    }

    public static LottoSet generateRandomLottoSetWithSize(int size) {
        Set<Lotto> randomLottos = new HashSet<>();
        for (int i = 0; i < size; i++) {
            randomLottos.add(new RandomLotto());
        }
        return new LottoSet(randomLottos);
    }

    public static LottoSet generateMixedLottoSet(ManualLottoNumberInputDTO manualLottoNumbersInput, PurchaseCount randomPurchaseCount) {
        Set<Lotto> mixedLottoSet = new HashSet<>();
        List<String> manualLottoInputs = manualLottoNumbersInput.getInput();

        for(String lottoInput : manualLottoInputs) {
            mixedLottoSet.add(new Lotto(LottoParser.generateLotto(lottoInput)));
        }

        mixedLottoSet.addAll(generateRandomLottoSetWithSize(randomPurchaseCount.getRandomLottoPurchaseCount()).getLottoSet());

        return new LottoSet(mixedLottoSet);
    }
}

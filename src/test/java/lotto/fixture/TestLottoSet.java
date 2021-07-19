package lotto.fixture;

import lotto.domain.Lotto;
import lotto.domain.LottoSet;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

public class TestLottoSet extends LottoSet {

    public TestLottoSet() {
        super(generateLottoSet());
    }

    public static HashSet<Lotto> generateLottoSet() {
        HashSet<Lotto> lottos = new HashSet<>();
        // 1등
        lottos.add(new Lotto(Arrays.stream(new int[]{1, 2, 3, 4, 5, 6}).boxed().collect(Collectors.toList())));

        // 2등
        lottos.add(new Lotto(Arrays.stream(new int[]{1, 2, 3, 4, 5, 7}).boxed().collect(Collectors.toList())));

        // 3등
        lottos.add(new Lotto(Arrays.stream(new int[]{1, 2, 3, 4, 5, 10}).boxed().collect(Collectors.toList())));
        lottos.add(new Lotto(Arrays.stream(new int[]{2, 3, 4, 5, 6, 10}).boxed().collect(Collectors.toList())));

        // 4등
        lottos.add(new Lotto(Arrays.stream(new int[]{1, 2, 3, 4, 10, 11}).boxed().collect(Collectors.toList())));
        lottos.add(new Lotto(Arrays.stream(new int[]{1, 3, 5, 6, 10, 11}).boxed().collect(Collectors.toList())));

        // 5등
        lottos.add(new Lotto(Arrays.stream(new int[]{2, 4, 6, 10, 11, 12}).boxed().collect(Collectors.toList())));
        lottos.add(new Lotto(Arrays.stream(new int[]{3, 4, 5, 10, 11, 12}).boxed().collect(Collectors.toList())));

        // 꽝
        lottos.add(new Lotto(Arrays.stream(new int[]{1, 12, 13, 14, 15, 16}).boxed().collect(Collectors.toList())));
        lottos.add(new Lotto(Arrays.stream(new int[]{11, 12, 13, 14, 15, 16}).boxed().collect(Collectors.toList())));

        return lottos;
    }

}

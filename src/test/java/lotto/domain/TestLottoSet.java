package lotto.domain;

import lotto.parser.LottoParser;

import java.util.HashSet;

public class TestLottoSet extends LottoSet {

    public TestLottoSet() {
        super(generateLottoSet());
    }

    public static HashSet<Lotto> generateLottoSet() throws IllegalArgumentException {
        HashSet<Lotto> lottos = new HashSet<>();
        lottos.add(new Lotto(LottoParser.parseInputIntoLottoNumbers("1, 2, 3, 4, 5, 6")));

        lottos.add(new Lotto(LottoParser.parseInputIntoLottoNumbers("1, 2, 3, 4, 5, 7")));
        lottos.add(new Lotto(LottoParser.parseInputIntoLottoNumbers("1, 2, 3, 4, 5, 7")));

        lottos.add(new Lotto(LottoParser.parseInputIntoLottoNumbers("1, 2, 3, 4, 5, 10")));
        lottos.add(new Lotto(LottoParser.parseInputIntoLottoNumbers("1, 2, 3, 4, 5, 10")));
        lottos.add(new Lotto(LottoParser.parseInputIntoLottoNumbers("1, 2, 3, 4, 5, 10")));

        lottos.add(new Lotto(LottoParser.parseInputIntoLottoNumbers("1, 2, 3, 4, 10, 11")));
        lottos.add(new Lotto(LottoParser.parseInputIntoLottoNumbers("1, 2, 3, 4, 10, 11")));
        lottos.add(new Lotto(LottoParser.parseInputIntoLottoNumbers("1, 2, 3, 4, 10, 11")));
        lottos.add(new Lotto(LottoParser.parseInputIntoLottoNumbers("1, 2, 3, 4, 10, 11")));

        lottos.add(new Lotto(LottoParser.parseInputIntoLottoNumbers("1, 2, 3, 10, 11, 12")));
        lottos.add(new Lotto(LottoParser.parseInputIntoLottoNumbers("1, 2, 3, 10, 11, 12")));
        lottos.add(new Lotto(LottoParser.parseInputIntoLottoNumbers("1, 2, 3, 10, 11, 12")));
        lottos.add(new Lotto(LottoParser.parseInputIntoLottoNumbers("1, 2, 3, 10, 11, 12")));
        lottos.add(new Lotto(LottoParser.parseInputIntoLottoNumbers("1, 2, 3, 10, 11, 12")));

        lottos.add(new Lotto(LottoParser.parseInputIntoLottoNumbers("1, 2, 10, 11, 12, 13")));
        lottos.add(new Lotto(LottoParser.parseInputIntoLottoNumbers("1, 10, 11, 12, 13, 14")));
        lottos.add(new Lotto(LottoParser.parseInputIntoLottoNumbers("19, 10, 11, 12, 13, 14")));

        return lottos;
    }

}

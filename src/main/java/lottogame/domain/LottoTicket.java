package lottogame.domain;

import java.util.List;

public class LottoTicket {

    private static final int LOTTO_NUMBER_COUNT = 6;
    private static LottoNumbers lottoNumbers = new LottoNumbers();

    private final List<Integer> lottoTicket;

    public LottoTicket(List<Integer> lottoTicket) {
        this.lottoTicket = lottoTicket;
    }

    public static LottoTicket generateLottoTicket() {
        lottoNumbers.shuffle();
        List<Integer> lottoTicket = lottoNumbers.selectLottoNumbersBy(LOTTO_NUMBER_COUNT);
        return new LottoTicket(lottoTicket);
    }

    @Override
    public String toString() {
        return "LottoTicket{" +
                "lottoTicket=" + lottoTicket +
                '}';
    }
}

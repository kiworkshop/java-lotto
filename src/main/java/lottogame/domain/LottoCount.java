package lottogame.domain;

public class LottoCount {

    public static final int ONE_LOTTO_PRICE = 1000;

    private final int lottoCount;

    private LottoCount(int lottoCount) {
        this.lottoCount = lottoCount;
    }

    public static LottoCount calculateTotalLottoCount(MoneyAmount moneyAmount) {
        int lottoCount = moneyAmount.getMoneyAmount() / ONE_LOTTO_PRICE;
        return new LottoCount(lottoCount);
    }

    public static LottoCount createLottoCount(int lottoCount, int totalLottoCount) {
        if (lottoCount > totalLottoCount) throw new IllegalArgumentException();
        return new LottoCount(lottoCount);
    }

    public static LottoCount createLottoCount(int lottoCount) {
        return new LottoCount(lottoCount);
    }

    public int getLottoCount() {
        return lottoCount;
    }
}

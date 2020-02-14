package lottogame.domain.winninglotto;

import lottogame.domain.lottoticket.LottoTicket;

public enum WinningLotto {

    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000),
    OTHERS(0, 0);

    private int hitCount;
    private long prizeMoney;

    WinningLotto(int hitCount, long prizePrice) {
        this.hitCount = hitCount;
        this.prizeMoney = prizePrice;
    }

    public static WinningLotto computeLottoStatistics(LottoTicket lottoTicket, LottoTicket lottoResult) {
        int hitCount = compareTwoTickets(lottoTicket, lottoResult);

        if (hitCount == FIRST.getHitCount()) return FIRST;
        if (hitCount == SECOND.getHitCount()) return SECOND;
        if (hitCount == THIRD.getHitCount()) return THIRD;
        if (hitCount == FOURTH.getHitCount()) return FOURTH;
        return OTHERS;
    }

    private static int compareTwoTickets(LottoTicket lottoTicket, LottoTicket lottoResult) {
        int hitCount = 0;
        for (int lottoNumber : lottoTicket.getSelectedLottoNumbers()) {
            if (lottoResult.getSelectedLottoNumbers().contains(lottoNumber)) hitCount += 1;
        }
        return hitCount;
    }

    public int getHitCount() {
        return hitCount;
    }

    public long getPrizeMoney() {
        return prizeMoney;
    }
}

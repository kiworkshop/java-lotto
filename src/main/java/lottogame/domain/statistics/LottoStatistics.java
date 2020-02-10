package lottogame.domain.statistics;

import lottogame.domain.lottoticket.LottoTicket;

public enum LottoStatistics {

    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FORTH(3, 5000),
    OTHERS(0, 0);

    private int hitCount;
    private long prizeMoney;

    public static LottoStatistics computeLottoStatistics(LottoTicket lottoTicket, LottoTicket lottoResult) {
        int hitCount = compareTwoTickets(lottoTicket, lottoResult);

        if (hitCount == FIRST.getHitCount()) return FIRST;
        if (hitCount == SECOND.getHitCount()) return SECOND;
        if (hitCount == THIRD.getHitCount()) return THIRD;
        if (hitCount == FORTH.getHitCount()) return FORTH;
        return OTHERS;
    }

    private static int compareTwoTickets(LottoTicket lottoTicket, LottoTicket lottoResult) {
        int hitCount = 0;
        for (int lottoNumber : lottoTicket.getSelectedLottoNumbers()) {
            if (lottoResult.getSelectedLottoNumbers().contains(lottoNumber)) hitCount += 1;
        }
        return hitCount;
    }

    LottoStatistics(int hitCount, long prizePrice) {
        this.hitCount = hitCount;
        this.prizeMoney = prizePrice;
    }

    public int getHitCount() {
        return hitCount;
    }

    public long getPrizeMoney() {
        return prizeMoney;
    }
}

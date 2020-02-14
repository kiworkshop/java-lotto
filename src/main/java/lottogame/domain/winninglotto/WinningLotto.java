package lottogame.domain.winninglotto;

import lottogame.domain.lottoticket.LottoTicket;

public enum WinningLotto {

    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    OTHERS(0, 0);

    private int hitCount;
    private long prizeMoney;

    WinningLotto(int hitCount, long prizePrice) {
        this.hitCount = hitCount;
        this.prizeMoney = prizePrice;
    }

    public static WinningLotto createWith(LottoTicket lottoTicket, LottoTicket lottoResult, int bonusNumber) {
        int hitCount = compareTwoTickets(lottoTicket, lottoResult);
        boolean hasBonusNumber = hasBonusNumber(lottoTicket, bonusNumber);

        if (hitCount == FIRST.getHitCount()) return FIRST;
        if (hitCount == SECOND.getHitCount() && hasBonusNumber) return SECOND;
        if (hitCount == THIRD.getHitCount() && !hasBonusNumber) return THIRD;
        if (hitCount == FOURTH.getHitCount()) return FOURTH;
        if (hitCount == FIFTH.getHitCount()) return FIFTH;
        return OTHERS;
    }

    private static int compareTwoTickets(LottoTicket lottoTicket, LottoTicket lottoResult) {
        int hitCount = 0;
        for (int lottoNumber : lottoTicket.getSelectedLottoNumbers()) {
            if (lottoResult.getSelectedLottoNumbers().contains(lottoNumber)) hitCount += 1;
        }
        return hitCount;
    }

    private static boolean hasBonusNumber(LottoTicket lottoTicket, int bonusNumber) {
        for (int lottonumber : lottoTicket.getSelectedLottoNumbers()) {
            if (lottonumber == bonusNumber) return true;
        }
        return false;
    }

    public int getHitCount() {
        return hitCount;
    }

    public long getPrizeMoney() {
        return prizeMoney;
    }
}

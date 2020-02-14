package lottogame.domain;

import lottogame.domain.lottoticket.LottoTicket;

public class BonusNumber {

    private final int bonusNumber;

    private BonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public static BonusNumber create(int bonusNumber, LottoTicket lottoResult) {
        if (hasDuplicate(bonusNumber, lottoResult)) throw new IllegalArgumentException();

        LottoNumbers.validateLottoNumber(bonusNumber);

        return new BonusNumber(bonusNumber);
    }

    private static boolean hasDuplicate(int bonusNumber, LottoTicket lottoResult) {
        for (Integer lottoNumber : lottoResult.getSelectedLottoNumbers()) {
            if (bonusNumber == lottoNumber) return true;
        }
        return false;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}

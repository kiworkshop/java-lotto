package lotto.view;

import lotto.constant.Prize;
import lotto.domain.*;
import lotto.domain.dto.ManualLottoNumberInputDTO;

public class OutputView {

    private static final String COMMA = ", ";

    public void printLottoCount(ManualLottoNumberInputDTO manualLottoNumberInput, PurchaseCount purchaseCount) {
        int manualCount = manualLottoNumberInput.getInput().size();
        int randomCount = purchaseCount.getPurchaseCount();
        System.out.println("수동으로 " + manualCount + "장, " + "자동으로 " + randomCount + "개를 구매했습니다.");
    }

    public void printLottoSet(LottoSet lottoSet) {
        for (Lotto lotto : lottoSet.getLottoSet()) {
            printLotto(lotto);
        }
    }

    private void printLotto(Lotto lotto) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (LottoNumber lottoNumber : lotto.getLottoNumbers()) {
            sb.append(lottoNumber.getLottoNumber()).append(COMMA);
        }
        System.out.println(removeCommaAtTheEnd(sb.toString()) + "]");
    }

    private String removeCommaAtTheEnd(String str) {
        return str.substring(0, str.length() - COMMA.length());
    }

    public void printLottoStatistic(LottoStatistics lottoStatistics) {
        StringBuilder sb = new StringBuilder();
        sb.append("당첨 통계\n");
        sb.append("---------\n");
        for (int i = 4; i >= 0; i--) {
            sb.append(Prize.values()[i].prizeMessage());
            sb.append(lottoStatistics.getPrizeCount().returnEachPrizeCount(i) + "개\n");
        }
        sb.append("총 수익률은 " + lottoStatistics.calculateProfitRate() + "입니다.");
        System.out.println(sb);
    }
}

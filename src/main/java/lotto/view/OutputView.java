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
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.print(Prize.FIFTH);
        System.out.println(lottoStatistics.getPrizeCount().getCountFifth() + "개");
        System.out.print(Prize.FOURTH);
        System.out.println(lottoStatistics.getPrizeCount().getCountFourth() + "개");
        System.out.print(Prize.THIRD);
        System.out.println(lottoStatistics.getPrizeCount().getCountThird() + "개");
        System.out.print(Prize.SECOND);
        System.out.println(lottoStatistics.getPrizeCount().getCountSecond() + "개");
        System.out.print(Prize.FIRST);
        System.out.println(lottoStatistics.getPrizeCount().getCountFirst() + "개");
        System.out.println("총 수익률은 " + lottoStatistics.calculateProfitRate() + "입니다.");
    }
}

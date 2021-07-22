package lotto.view;

import lotto.constant.PrizeMessage;
import lotto.domain.*;

public class OutputView {

    private static final String COMMA = ", ";

    public void printLottoCount(PurchaseCount purchaseCount) {
        int count = purchaseCount.getPurchaseCount();
        System.out.println(count + "개를 구매했습니다.");
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
        System.out.print(PrizeMessage.FIFTH.getMessage());
        System.out.println(lottoStatistics.getPrizeCount().getCountFifth() + "개");
        System.out.print(PrizeMessage.FOURTH.getMessage());
        System.out.println(lottoStatistics.getPrizeCount().getCountFourth() + "개");
        System.out.print(PrizeMessage.THIRD.getMessage());
        System.out.println(lottoStatistics.getPrizeCount().getCountThird() + "개");
        System.out.print(PrizeMessage.SECOND.getMessage());
        System.out.println(lottoStatistics.getPrizeCount().getCountSecond() + "개");
        System.out.print(PrizeMessage.FIRST.getMessage());
        System.out.println(lottoStatistics.getPrizeCount().getCountFirst() + "개");
        System.out.println("총 수익률은 " + lottoStatistics.calculateProfitRate() + "입니다.");
    }
}

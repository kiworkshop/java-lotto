package lotto.view;

import lotto.constant.PrizeMessage;
import lotto.domain.*;

public class OutputView {

    private static final String COMMA = ", ";
    private static final String PARENTHESIS_LEFT = "[";
    private static final String PARENTHESIS_RIGHT = "]";
    private static final String UNIT = "개";
    private static final String NEW_LINE = "\n";

    private void print(String contents) {
        System.out.println(contents);
    }

    public void printLottoCount(PurchaseCount purchaseCount) {
        int count = purchaseCount.getPurchaseCount();
        print(count + "개를 구매했습니다.");
    }

    public void printLottoSet(RandomLottoSet lottoSet) {
        for (Lotto lotto : lottoSet.getLottoSet()) {
            printLotto(lotto);
        }
    }

    private void printLotto(Lotto lotto) {
        String result = PARENTHESIS_LEFT;
        for (LottoNumber lottoNumber : lotto.getLottoNumbers()) {
            result += lottoNumber.getLottoNumber() + COMMA;
        }
        result = removeCommaAtTheEnd(result) + PARENTHESIS_RIGHT;

        print(result);
    }

    private String removeCommaAtTheEnd(String str) {
        return str.substring(0, str.length() - COMMA.length());
    }

    public void askPurchaseCost() {
        print("구입금액을 입력해 주세요.");
    }

    public void askWinningLottoNumbers() {
        print("지난 주 당첨 번호를 입력해 주세요.");
    }

    public void askWinningLottoBonus() {
        print("보너스 볼을 입력해 주세요.");
    }

    public void printLottoStatistic(LottoStatistics lottoStatistics) {
        String result = "당첨 통계" + "---------" + NEW_LINE +
                generatePrizeMessage(PrizeMessage.FIFTH, lottoStatistics.getPrizeCount().getCountFifth()) +
                generatePrizeMessage(PrizeMessage.FOURTH, lottoStatistics.getPrizeCount().getCountFourth()) +
                generatePrizeMessage(PrizeMessage.THIRD, lottoStatistics.getPrizeCount().getCountThird()) +
                generatePrizeMessage(PrizeMessage.SECOND, lottoStatistics.getPrizeCount().getCountSecond()) +
                generatePrizeMessage(PrizeMessage.FIRST, lottoStatistics.getPrizeCount().getCountFirst()) +
                generateProfitRateMessage(lottoStatistics.calcProfitRate());
        print(result);
    }

    private String generatePrizeMessage(PrizeMessage prizeMessage, int prizeCount) {
        return prizeMessage.getMessage() + prizeCount + UNIT + NEW_LINE;
    }

    private String generateProfitRateMessage(double profitRate) {
        return "총 수익률은 " + profitRate + "입니다.";
    }
}

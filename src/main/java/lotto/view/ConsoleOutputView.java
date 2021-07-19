package lotto.view;

import lotto.domain.*;
import lotto.domain.dto.LottoResult;

public class ConsoleOutputView implements OutputView {

    private static final String ERROR_HEADER = "[ERROR] ";

    private void print(String contents) {
        System.out.println(contents);
    }

    public void printLottoCount(PurchaseCount purchaseCount) {
        int count = purchaseCount.getPurchaseCount();
        print(count + "개를 구매했습니다.");
    }

    public void printLottoSet(LottoSet lottoSet) {
        for (Lotto lotto : lottoSet.getLottoSet()) {
            printLotto(lotto);
        }
    }

    private void printLotto(Lotto lotto) {
        String result = "[";
        for (LottoNumber lottoNumber : lotto.getLottoNumbers()) {
            result += lottoNumber.getLottoNumber() + ", ";
        }
        result = removeCommaAtTheEnd(result) + "]";

        print(result);
    }

    private String removeCommaAtTheEnd(String str) {
        return str.substring(0, str.length() - 2);
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

    public void printLottoStatistic(LottoResult lottoStatistics) {
        String result = "당첨 통계\n---------\n" +
                generatePrizeResultMessage(Prize.FIFTH, lottoStatistics.getPrizeCount().getFifth()) +
                generatePrizeResultMessage(Prize.FOURTH, lottoStatistics.getPrizeCount().getFourth()) +
                generatePrizeResultMessage(Prize.THIRD, lottoStatistics.getPrizeCount().getThird()) +
                generatePrizeResultMessage(Prize.SECOND, lottoStatistics.getPrizeCount().getSecond()) +
                generatePrizeResultMessage(Prize.FIRST, lottoStatistics.getPrizeCount().getFirst()) +
                generateProfitRateMessage(lottoStatistics.getProfitRate());
        print(result);
    }

    private String generatePrizeResultMessage(Prize prize, int prizeCount) {
        return generatePrizeResultMessage(prize) + prizeCount + "개\n";
    }

    private String generatePrizeResultMessage(Prize prize) {
        StringBuilder sb = new StringBuilder();
        sb.append(prize.getMatchNumbersCount())
                .append("개 일치");
        if (prize.isBonus()) {
            sb.append(", 보너스 볼 일치 ");
        }
        sb.append("(")
                .append(prize.getPrizeMoney())
                .append("원)- ");
        return sb.toString();
    }

    private String generateProfitRateMessage(double profitRate) {
        return "총 수익률은 " + profitRate + "입니다.";
    }

    public void printException(String message) {
        print(ERROR_HEADER + message);
    }
}

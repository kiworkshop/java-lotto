package lotto.view;

import lotto.domain.Prize;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.PurchaseCount;
import lotto.domain.RandomLottoSet;
import lotto.domain.dto.StatisticsResultDTO;

public class OutputView {

    private static final String ERROR_HEADER = "[ERROR] ";
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

    public void printLottoStatistic(StatisticsResultDTO lottoStatistics) {
        String result = "당첨 통계" + "---------" + NEW_LINE +
                generatePrizeResultMessage(Prize.FIFTH, lottoStatistics.getPrizeCount().getCountFifth()) +
                generatePrizeResultMessage(Prize.FOURTH, lottoStatistics.getPrizeCount().getCountFourth()) +
                generatePrizeResultMessage(Prize.THIRD, lottoStatistics.getPrizeCount().getCountThird()) +
                generatePrizeResultMessage(Prize.SECOND, lottoStatistics.getPrizeCount().getCountSecond()) +
                generatePrizeResultMessage(Prize.FIRST, lottoStatistics.getPrizeCount().getCountFirst()) +
                generateProfitRateMessage(lottoStatistics.getProfitRate());
        print(result);
    }

    private String generatePrizeResultMessage(Prize prize, int prizeCount) {
        return generatePrizeResultMessage(prize) + prizeCount + UNIT + NEW_LINE;
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

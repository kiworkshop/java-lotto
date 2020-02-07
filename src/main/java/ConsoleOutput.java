public class ConsoleOutput {
    public static void printBuyingMessage(int amount) {
        System.out.println(amount + "개를 구매하였습니다");
    }

    public static void printResults(LottoResult results) {
        System.out.println("당첨통계");
        System.out.println("---------");
        System.out.println(results.toString());

    }

    public static void printEarnningRate(int earningRate) {
        System.out.println("총 수익률은 " + earningRate + "% 입니다.");

    }
}

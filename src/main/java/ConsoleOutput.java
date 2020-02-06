public class ConsoleOutput {
    public static void printBuyingMessage(int amount) {
        System.out.println(amount + "개를 구매하였습니다");
    }

    public static void printResults(LottoResult results) {
        System.out.println("당첨통계");
        System.out.println("---------");
        System.out.println(results.toString());

    }
}

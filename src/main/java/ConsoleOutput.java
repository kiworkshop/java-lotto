class ConsoleOutput {
    static void printBuyingMessage(int manualLottoAmount, int autoLottoAmount) {
        System.out.println("수동으로 " + manualLottoAmount + ", 자동으로 " + manualLottoAmount + "장을 구매하였습니다");
    }

    static void printResults(LottoResults results) {
        System.out.println("당첨통계");
        System.out.println("---------");
        System.out.println(results.toString());

    }

    static void printEarnningRate(int earningRate) {
        System.out.println("총 수익률은 " + earningRate + "% 입니다.");

    }
}

import java.util.List;

class LottoGame {
    private static final int LOTTO_PRICE = 1000;
    private static final int PERCENTAGE_FACTOR = 100;
    private int amount;

    LottoGame() {
        int budget = ConsoleInput.inputBudget();
        this.amount = budget / LOTTO_PRICE;
    }

    void run() {
        ConsoleOutput.printBuyingMessage(amount);
        Lottos lottos = makeLottosAuto(amount);
        System.out.println(lottos.toString());
        List<Integer> winningNumbers = ConsoleInput.inputWinningNumbers();
        ConsoleOutput.printResults(lottos.getResults(winningNumbers));
        ConsoleOutput.printEarnningRate(getEarningRate(lottos.getResults(winningNumbers).getPrize(), amount * LOTTO_PRICE));
    }

    private int getEarningRate(int prize, int cost) {
        return prize * PERCENTAGE_FACTOR / cost;

    }

    private Lottos makeLottosAuto(int amount) {
        Lottos lottos = new Lottos();
        for (int i = 0; i < amount; i++) {
            lottos.add(Lotto.autoGenerate());
        }
        return lottos;
    }
}

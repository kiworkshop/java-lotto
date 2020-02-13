class LottoGame {
    private static final int LOTTO_PRICE = 1000;
    private static final int PERCENTAGE_FACTOR = 100;
    private int amount;

    LottoGame() {
        int budget = ConsoleInput.inputBudget();
        this.amount = budget / LOTTO_PRICE;
    }

    void run() {
        Lottos lottos = buyLotto();
        System.out.println(lottos.toString());
//        List<Integer> winningNumbers = ConsoleInput.inputWinningNumbers();
        WinningNumbers winningNumbers = WinningNumbers.of(ConsoleInput.inputWinningNumbers(), ConsoleInput.inputBonusNumber());
        ConsoleOutput.printResults(lottos.getResults(winningNumbers));
        ConsoleOutput.printEarnningRate(getEarningRate(lottos.getResults(winningNumbers).getPrize(), amount * LOTTO_PRICE));
    }

    private Lottos buyLotto() {
        int manualLottoAmount = ConsoleInput.inputManualLottoAmount();
        int autoLottoAmount = amount - manualLottoAmount;
        Lottos lottos = ConsoleInput.inputManualLottoNumbers(manualLottoAmount);
        makeLottosAuto(lottos, autoLottoAmount);
        ConsoleOutput.printBuyingMessage(manualLottoAmount, autoLottoAmount);

        return lottos;
    }

    private int getEarningRate(int prize, int cost) {
        return prize * PERCENTAGE_FACTOR / cost;

    }

    private void makeLottosAuto(Lottos lottos, int amount) {
        for (int i = 0; i < amount; i++) {
            lottos.add(Lotto.autoGenerate());
        }
    }
}

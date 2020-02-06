public class LottoGame {
    public static final int LOTTO_PRICE = 1000;
    private int budget;
    private int amount;

    public LottoGame() {
        this.budget = ConsoleInput.inputBudget();
        this.amount = budget / LOTTO_PRICE;
    }

    public void run() {
        ConsoleOutput.printBuyingMessage(amount);
        Lottos lottos = makeLottosAuto(amount);
        System.out.println(lottos.toString());
        ConsoleInput.inputWinningNumbers();

    }

    public Lottos makeLottosAuto(int amount) {
        Lottos lottos = new Lottos();
        for (int i = 0; i < amount; i++) {
            lottos.add(Lotto.autoGenerate());
        }
        return lottos;
    }
}

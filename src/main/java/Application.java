import controller.LottoController;
import domain.lotto.UserLottos;
import domain.lotto.WinningLotto;
import domain.money.LottoMoney;
import domain.result.UserRanks;
import view.input.LottoInputScanner;
import view.output.LottoOutputPrinter;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController();
        LottoMoney lottoMoney = lottoController.createMoney(LottoInputScanner.askLottoPurchacePrice());
        UserLottos userLottos = lottoController.publishUserLottos(lottoMoney);
        LottoOutputPrinter.printUserLottos(userLottos);
        WinningLotto winningLotto = lottoController.createWinningLotto(LottoInputScanner.askLottoWinningNumber(), LottoInputScanner.askBonusNumber());
        UserRanks userRanks = lottoController.createUserRanks(winningLotto, userLottos);
        LottoOutputPrinter.printUserRanks(userRanks);
    }
}

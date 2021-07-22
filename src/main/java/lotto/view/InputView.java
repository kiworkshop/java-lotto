package lotto.view;

import lotto.domain.dto.PurchasePriceInputDTO;
import lotto.domain.dto.WinningLottoInputDTO;
import lotto.util.NumberValidateUtils;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    public PurchasePriceInputDTO getPurchaseCost() {
        System.out.println("구입금액을 입력해 주세요.");
        String purchaseCountInput = scanner.nextLine();

        return new PurchasePriceInputDTO(purchaseCountInput);
    }

    public WinningLottoInputDTO getWinningLottoAndBonus() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String winningLottoNumbers = scanner.nextLine();

        System.out.println("보너스 볼을 입력해 주세요.");
        String winningLottoBonus = scanner.nextLine();

        NumberValidateUtils.numericCheck(winningLottoBonus);

        return new WinningLottoInputDTO(winningLottoNumbers, winningLottoBonus);
    }
}

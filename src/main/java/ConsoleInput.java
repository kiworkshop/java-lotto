import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class ConsoleInput {
    private static final String MESSAGE_INPUT_MONEY = "구입 금액을 입력해주세요";
    private static final String MESSAGE_INPUT_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해주세요";
    private static Scanner scanner = new Scanner(System.in);

    static int inputBudget() {
        System.out.println(MESSAGE_INPUT_MONEY);
        return scanner.nextInt();
    }

    static List<Integer> inputWinningNumbers() {
        System.out.println(MESSAGE_INPUT_WINNING_NUMBERS);
        String winningNumbers = scanner.next();    //TODO 왜 nextline안돼? ㅠ
        return Arrays.stream(winningNumbers.split(",")).map(Integer::parseInt).collect(Collectors.toList());
    }

    public static int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해주세요");
        return scanner.nextInt();
    }

    public static int inputManualLottoAmount() {
        System.out.println("수동으로 구매할 로또 수를 입력해주세요");
        return scanner.nextInt();
    }

    public static Lottos inputManualLottoNumbers(int manualLottoAmount) {
        scanner.nextLine();
        Lottos lottos = new Lottos();
        System.out.println("수동으로 구매할 번호를 입력해주세요");
        for (int i = 0; i < manualLottoAmount; i++) {
            String winningNumbers = scanner.nextLine();    //TODO 왜 nextline안돼? ㅠ
            lottos.add(Lotto.manualGenerate(Arrays.stream(winningNumbers.split(",")).map(Integer::parseInt).collect(Collectors.toList())));
        }
        return lottos;
    }
}

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
}

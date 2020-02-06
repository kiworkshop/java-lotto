import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ConsoleInput {
    private static Scanner scanner = new Scanner(System.in);

    public static int inputBudget() {
        System.out.println("구입 금액을 입력해주세요");
        return scanner.nextInt();
    }

    public static List<Integer> inputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해주세요");
        String winningNumbers = scanner.next();    //TODO 왜 nextline안돼? ㅠ
        return Arrays.stream(winningNumbers.split(",")).map(Integer::parseInt).collect(Collectors.toList());
    }
}

import java.util.Scanner;

public class ConsoleInput {
    private static Scanner scanner = new Scanner(System.in);

    public static int inputBudget() {
        System.out.println("구입 금액을 입력해주세요");
        return scanner.nextInt();
    }
}

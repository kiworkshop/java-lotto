import java.util.regex.Pattern;

public class LottoService {

    public void validate(String input) {
        if (!Pattern.matches("^[0-9]*$", input)) {
            throw new RuntimeException("잘못된 입력입니다");
        }
        int inputConversion = Integer.parseInt(input);
        if (notMatchesCondition(inputConversion)) {
            throw new IllegalArgumentException("입력값이 잘못되었습니다");
        }
    }

    private boolean notMatchesCondition(int input) {
        return input < 1000 || input % 1000 != 0;
    }
}

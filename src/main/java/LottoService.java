public class LottoService {

    public void validate(int input) {
        if (notMatchesCondition(input)) {
            throw new IllegalArgumentException("입력값이 잘못되었습니다");
        }
    }

    private boolean notMatchesCondition(int input) {
        return input < 1000 || input % 1000 != 0;
    }
}

public class LottoService {

    public void validate(int input) {
        if(input < 1000) {
            throw new RuntimeException("입력값이 잘못되었습니다");
        }
    }
}

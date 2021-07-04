package utils;

import domain.LottoMachine;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputValicationTest {

    static InputValication inputValication = new InputValication();

    @Test
    void 문자_1000을_입력받으면_숫자1000을_리턴한다() {
        //given
        String givenMoney = "1000";
        //when
        int result = inputValication.checkGivenMoeny(givenMoney);
        //then
        assertThat(result).isEqualTo(1000);
    }
    
    @Test
    void 문자_100을_입력받으면_런타임에러를_리턴한다() {
        //given
        String givenMoney = "100";
        //when
        //then
        assertThatThrownBy(() ->
                inputValication.checkGivenMoeny(givenMoney)).
                isInstanceOf(RuntimeException.class);
    }
    @Test
    void 문자_가를_입력받으면_런타임에러를_리턴한다() {
        //given
        String givenMoney = "가";
        //when
        //then
        assertThatThrownBy(() ->
                inputValication.checkGivenMoeny(givenMoney)).
                isInstanceOf(RuntimeException.class);
    }
    
    @Test
    void 문자_음수1000_입력받으면_런타임에러를_리턴한다() {
        //given
        String givenMoney = "-1000";
        //when
        //then
        assertThatThrownBy(() ->
                inputValication.checkGivenMoeny(givenMoney)).
                isInstanceOf(RuntimeException.class);
    }
}

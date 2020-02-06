package lottogame.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MoneyAmountTest {

    private MoneyAmount 천원;

    @BeforeEach
    void setUp() {
        천원 = new MoneyAmount(1000);
    }

    @Test
    void 천원의_moneyAmount는_1000() {
        // given
        int moneyAmount = 천원.getMoneyAmount();

        // then
        assertThat(moneyAmount).isEqualTo(1000);
    }

    @Test
    void moneyAmount는_천원이상이어야한다() {
        // then
        assertThrows(IllegalArgumentException.class, () -> new MoneyAmount(999));
    }

    @Test
    void moneyAmount는_1000의_배수여야한다() {
        // then
        assertThrows(IllegalArgumentException.class, () -> new MoneyAmount(1100));
    }
}
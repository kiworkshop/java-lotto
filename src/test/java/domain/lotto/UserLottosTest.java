package domain.lotto;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static domain.lotto.LottoTest.getLottoFromOneToSixFixture;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;


class UserLottosTest {

    @Test
    void testUserLottos() {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            lottos.add(getLottoFromOneToSixFixture());
        }

        UserLottos userLottos = UserLottos.from(lottos);
        assertThat(userLottos.getLottos()).size().isEqualTo(10);
    }
}
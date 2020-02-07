package domain.lotto;

import java.util.ArrayList;
import java.util.List;

public class UserLottos {

    List<Lotto> lottos = new ArrayList<>();

    public static UserLottos from(List<Lotto> lottos) {
        return new UserLottos(lottos);
    }

    private UserLottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}

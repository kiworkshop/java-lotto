package domain.lotto;

import java.util.List;

public class UserLottos {

    List<Lotto> lottos;

    private UserLottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static UserLottos from(List<Lotto> lottos) {
        return new UserLottos(lottos);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}

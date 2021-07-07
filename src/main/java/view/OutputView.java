package view;

import domain.Lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OutputView {
    public void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (int i = 0; i < lottos.size(); i++) {
            System.out.println(lottos.get(i).getLottoNumberString());
        }
    }
}

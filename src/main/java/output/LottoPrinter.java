package output;

import domain.lotto.Lotto;
import domain.lotto.UserLottos;

import java.util.List;

public class LottoPrinter {

    public static void printUserLottos(UserLottos userLottos) {
        List<Lotto> lottoList = userLottos.getLottos();
        System.out.println(lottoList.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottoList) {
            System.out.println(lotto);
        }
    }
}

package lotto.domain;

import lombok.Getter;

@Getter
public class PrizeCount {

    private int first;
    private int second;
    private int third;
    private int fourth;
    private int fifth;

    public void addPrize(Prize prize) {
        if (prize == Prize.FIRST) {
            first++;
            return;
        }
        if (prize == Prize.SECOND) {
            second++;
            return;
        }
        if (prize == Prize.THIRD) {
            third++;
            return;
        }
        if (prize == Prize.FOURTH) {
            fourth++;
            return;
        }
        if (prize == Prize.FIFTH) {
            fifth++;
        }
    }
}

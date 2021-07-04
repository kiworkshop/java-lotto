package domain;

import org.graalvm.compiler.phases.common.inlining.info.elem.InlineableGraph;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {

    private static List<Integer> balls = IntStream.range(1,45).boxed().collect(Collectors.toList());

    public int getLottoTickt(int givenMoney) {
        return givenMoney/1000;
    }

    public List<Integer> createRandomNumber() {
        Collections.shuffle(balls);
        List<Integer> lottoNumbers = balls.subList(0,6);
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }
}

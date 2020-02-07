import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {
    private static final String DELIMITER_NUMBERS = "\n";
    private List<Lotto> lottos;

    public Lottos() {
        this.lottos = new ArrayList<>();

    }

    public String toString() {
        return lottos.stream().map(Lotto::toString).collect(Collectors.joining(DELIMITER_NUMBERS));

    }

    public void add(Lotto lotto) {
        this.lottos.add(lotto);
    }

    public LottoResult getResults(List<Integer> winningNumber) {
        List<Integer> matchCounts = new ArrayList<>();
        for (Lotto lotto : lottos) {
            matchCounts.add(lotto.checkHits(winningNumber));
        }
        return LottoResult.of(matchCounts);
    }

}

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

    public LottoResults getResults(WinningNumbers winningNumbers) {
        List<LottoRank> countOfMatchesForEachLotto = new ArrayList<>();
        for (Lotto lotto : lottos) {
            countOfMatchesForEachLotto.add(LottoRank.checkHits(lotto, winningNumbers));
        }
        return LottoResults.of(countOfMatchesForEachLotto);
    }

}

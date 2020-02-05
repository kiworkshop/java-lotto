import com.sun.tools.javac.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class Lottos {
    private List<Lotto> lottos;

    public Lottos() {
        this.lottos = new ArrayList<>();

    }

    public String toString() {
        return lottos.stream().map(Lotto::toString).collect(Collectors.joining("\n"));

    }
    public void add(Lotto lotto) {
        this.lottos.add(lotto);
    }
}

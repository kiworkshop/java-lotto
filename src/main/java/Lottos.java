import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private ArrayList<Lotto> lottos;

    public Lottos() {
        this.lottos = new ArrayList<>();

    }

    @Override
    public String toString() {
        return "Lottos{" +
                "Lottos=" + lottos +
                '}';
    }

    public void add(Lotto lotto) {
        this.lottos.add(lotto);
    }
}

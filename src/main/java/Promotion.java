import java.util.Arrays;
import java.util.List;

public class Promotion {
    private List<Sell> sells;
    private Long lapso;
    private Double percentage;

    public Promotion(Long lapso, Double percentage, Sell ... sells) {
        this.lapso = lapso;
        this.percentage = percentage;
        this.sells = Arrays.asList(sells);
    }

    public Fee fee() {
        return sells.stream().map(Sell::fee).reduce(new Fee(0), (a, b) -> a.plus(b.percentage(100 - this.percentage)));
    }
}

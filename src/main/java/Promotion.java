import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;

public class Promotion {
    private static final Long MILLIS_PER_HOUR = 60L * 60 * 1000;

    private List<Sell> sells;
    private Long lapseInMillis;
    private Double percentage;

    public Promotion(Long lapseInHours, Double percentage, Sell ... sells) {
        this.lapseInMillis = lapseInHours * MILLIS_PER_HOUR;
        this.percentage = percentage;
        this.sells = Arrays.asList(sells);
    }

    public Fee fee() {
        return this.sells.stream()
                .filter(s -> this.sells.stream()
                        .anyMatch(p -> {
                            long difference = Math.abs(ChronoUnit.MILLIS.between(s.sellingDate(), p.sellingDate()));
                            return difference > 0 && difference <= this.lapseInMillis;
                        }))
                .map(Sell::fee)
                .reduce(new Fee(0), Fee::plus).percentage(100 - this.percentage);
    }
}

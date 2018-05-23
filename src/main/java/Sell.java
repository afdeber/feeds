import java.time.LocalDateTime;

public interface Sell {
    Fee fee();

    Cost cost();

    LocalDateTime sellingDate();
}

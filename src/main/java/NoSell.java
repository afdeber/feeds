import java.time.LocalDateTime;

public class NoSell implements Sell {
    @Override
    public Fee fee() {
        return new Fee(0.0);
    }

    @Override
    public Cost cost() {
        return new Cost(0.0);
    }

    @Override
    public LocalDateTime sellingDate() {
        return LocalDateTime.now();
    }
}

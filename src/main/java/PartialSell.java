import java.time.LocalDateTime;

public class PartialSell implements Sell {

    private Sell sellCached;
    private Sell defaultSell;

    public PartialSell(SingleSell sell) {
        this.sellCached = sell;
        this.defaultSell = new NoSell();
    }

    public PartialSell(Item item) {
        this.sellCached = new SingleSell(item, new NoShipment());
        this.defaultSell = new NoSell();
    }

    @Override
    public Fee fee() {
        return new FeeBasedOnDefault(defaultSell).calculate();
    }

    @Override
    public Cost cost() {
        return this.defaultSell.cost();
    }

    @Override
    public LocalDateTime sellingDate() {
        return this.sellCached.sellingDate();
    }

    public PartialSell and(Item item) {
        return this;
    }

    public PartialSell close() {
        this.defaultSell = this.sellCached;
        return this;
    }
}

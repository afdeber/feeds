import calendar.BlackDaysCalendar;
import calendar.NoneCalendar;

import java.time.LocalDateTime;
import java.util.Arrays;

public class SingleSell implements Sell {
    private final Item item;
    private final Shipment shipment;
    private final LocalDateTime sellingDate;

    public SingleSell(Item item, Shipment shipment) {
        this(item, shipment, LocalDateTime.now());
    }

    public SingleSell(Item item, Shipment shipment, LocalDateTime sellingDate) {
        this.item = item;
        this.shipment = shipment;
        this.sellingDate = sellingDate;
    }

    @Override
    public LocalDateTime sellingDate() {
        return sellingDate;
    }

    @Override
    public Fee fee() {
        return this.fee(new NoneCalendar());
    }

    @Override
    public Cost cost() {
        return item.accumulateCost(shipment);
    }

    public Fee fee(BlackDaysCalendar calendar) {
        return Arrays.asList(
                new FeeBasedOnCalendar(this.item, this.shipment, calendar ),
                new FeeBasedOnItemPriceBiggerThan(this.item, this.shipment, 1000.0)
        ).stream()
                .reduce(new FeeBasedOnDefault(this.item, this.shipment), (a, b) -> a = a.oust(b))
                .calculate();
    }

    public PartialSell and(Item item) {
        return new PartialSell(this).and(item);
    }
}

import java.time.LocalDateTime;

public class Seller {
    public SingleSell sells(Item item, Shipment shipment) {
        return sells(item, shipment, LocalDateTime.now());
    }

    public SingleSell sells(Item item, Shipment shipment, LocalDateTime sellingDate) {
        return new SingleSell(item, shipment, sellingDate);
    }

    public PartialSell sells(Item item) {
        return new PartialSell(item);
    }
}

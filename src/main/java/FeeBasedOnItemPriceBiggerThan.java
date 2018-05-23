public class FeeBasedOnItemPriceBiggerThan implements  Rival {
    private final Item item;
    private final Shipment shipment;
    private final Double itemPriceParam;

    public FeeBasedOnItemPriceBiggerThan(Item item, Shipment shipment, double v) {
        this.item = item;
        this.shipment = shipment;
        this.itemPriceParam = v;
    }

    @Override
    public Fee calculate() {
        Fee accumulated = item.accumulateFee( shipment);
        return accumulated.percentage(2.0);
    }

    @Override
    public Rival oust(Rival policy) {
        if ( this.item.isBiggerThan(this.itemPriceParam) ) {
            return this;
        }

        return new FeeBasedOnDefault(this.item, this.shipment);
    }
}

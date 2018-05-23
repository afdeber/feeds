public class Item {
    private final Double cost;

    public Item(Double cost) {
        this.cost = cost;
    }

    public Fee accumulateFee(Shipment shipment) {
        return this.accumulateCost(shipment).asFee();

    }

    public Fee percentage(double value) {
        return new Fee(this.cost * value / 100);
    }

    public boolean isBiggerThan(double value) {
        return this.cost >= value;
    }

    public Cost accumulateCost(Shipment shipment) {
        Double result = this.cost;
        return shipment.accumulateCostHere(result);
    }
}

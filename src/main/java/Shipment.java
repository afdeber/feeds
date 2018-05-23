public class Shipment {
    private final Double cost;

    public Shipment(Double cost) {
        this.cost = cost;
    }

    public Cost accumulateCostHere(Double result) {
        return new Cost( result += this.cost );
    }
}

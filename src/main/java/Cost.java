public class Cost {
    private final Double value;

    public Cost(double value) {
        this.value = value;
    }

    public Cost percentage(double percentage) {
        return new Cost(this.value * percentage / 100 );
    }

    public Fee asFee() {
        return new Fee(this.value);
    }
}

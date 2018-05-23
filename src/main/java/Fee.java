public class Fee {
    private final Double value;

    public Fee(double value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object other) {
        Fee another = (Fee)other;
        return this.value.equals(another.value);
    }

    public Fee percentage(Double percentage) {
        return new Fee(this.value * percentage / 100 );
    }

    public Fee plus(Fee fee) {
        return new Fee(this.value + fee.value);
    }
}

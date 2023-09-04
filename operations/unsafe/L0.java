package operations.unsafe;


import expression.Expression;

public class L0 implements Expression {
    private final Expression value;

    public L0(Expression value) {
        this.value = value;
    }

    @Override
    public int evaluate(int x) {
        return Integer.numberOfLeadingZeros(value.evaluate(x));
    }

    @Override
    public int evaluate(int x, int y, int z) {
        return Integer.numberOfLeadingZeros(value.evaluate(x, y, z));
    }

    @Override
    public String toString() {
        return "l0(" + value + ")";
    }

}

package operations.unsafe;


import expression.Expression;

public class T0 implements Expression {
    private final Expression expression;

    public T0(Expression value) {
        this.expression = value;
    }

    @Override
    public int evaluate(int x) {
        return Integer.numberOfTrailingZeros(expression.evaluate(x));
    }

    @Override
    public int evaluate(int x, int y, int z) {
        return Integer.numberOfTrailingZeros(expression.evaluate(x, y, z));
    }

    @Override
    public String toString() {
        return "t0(" + expression + ")";
    }

}

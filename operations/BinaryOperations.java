package operations;


import expression.Expression;

import java.util.Objects;

public abstract class BinaryOperations implements Expression {
    private final Expression firstEx;
    private final Expression secondEx;

    public BinaryOperations(Expression firstEx, Expression secondEx) {
        this.firstEx = firstEx;
        this.secondEx = secondEx;
    }


    @Override
    public int evaluate(int x, int y, int z) {
        return calculate(firstEx.evaluate(x, y, z), secondEx.evaluate(x, y, z));
    }

    @Override
    public int evaluate(int x) {
        return calculate(firstEx.evaluate(x), secondEx.evaluate(x));
    }


    @Override
    public int hashCode() {
        return Objects.hash(firstEx, secondEx, getClass());
    }

    @Override
    public String toString() {
        return "(" + firstEx.toString() + getSign() + secondEx.toString() + ")";
    }

    protected abstract String getSign();

    protected abstract int calculate(int first, int second);

}

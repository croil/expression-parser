package operations.unsafe;


import expression.Expression;
import operations.BinaryOperations;

public class Max extends BinaryOperations {

    public Max(Expression firstEx, Expression secondEx) {
        super(firstEx, secondEx);
    }

    @Override
    protected String getSign() {
        return " max ";
    }

    @Override
    protected int calculate(int first, int second) {
        return Math.max(first, second);
    }
}

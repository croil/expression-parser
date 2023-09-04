package operations.unsafe;


import expression.Expression;
import operations.BinaryOperations;

public class Subtract extends BinaryOperations {

    public Subtract(Expression firstEx, Expression secondEx) {
        super(firstEx, secondEx);
    }

    @Override
    protected int calculate(int first, int second) {
        return first - second;
    }

    @Override
    protected String getSign() {
        return " - ";
    }
}

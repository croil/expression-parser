package operations.unsafe;


import expression.Expression;
import operations.BinaryOperations;

public class Min extends BinaryOperations {
    public Min(Expression first, Expression second) {
        super(first, second);
    }

    @Override
    protected String getSign() {
        return " min ";
    }

    @Override
    protected int calculate(int first, int second) {
        return Math.min(first, second);
    }

}

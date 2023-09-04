package operations.safe;

import exceptions.overflow.NegateOverflowException;
import expression.Expression;
import operations.unsafe.Negative;

public class CheckedNegate extends Negative {
    private final Expression expression;

    public CheckedNegate(Expression expression) {
        super(expression);
        this.expression = expression;
    }

    @Override
    public int evaluate(int x) {
        int result = expression.evaluate(x);
        if (result == Integer.MIN_VALUE) {
            throw new NegateOverflowException("overflow");
        }
        return (-1) * result;
    }

    @Override
    public int evaluate(int x, int y, int z) {
        int result = expression.evaluate(x, y, z);
        if (result == Integer.MIN_VALUE) {
            throw new NegateOverflowException("overflow");
        }
        return (-1) * result;
    }

}

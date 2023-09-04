package operations.safe;

import exceptions.overflow.MultiplyOverflowException;
import expression.Expression;
import operations.unsafe.Multiply;

public class CheckedMultiply extends Multiply {
    public CheckedMultiply(Expression firstEx, Expression secondEx) {
        super(firstEx, secondEx);
    }

    @Override
    protected int calculate(int first, int second) {
        int value = first * second;
        if (first < 0 && second < 0 && value < 0 || first != 0 && second != 0 && first * second / first != second) {
            throw new MultiplyOverflowException("overflow");
        }
        return value;
    }

}

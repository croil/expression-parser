package operations.safe;

import exceptions.overflow.SubtractOverflowException;
import expression.Expression;
import operations.unsafe.Subtract;

public class CheckedSubtract extends Subtract {
    public CheckedSubtract(Expression firstEx, Expression secondEx) {
        super(firstEx, secondEx);
    }

    @Override
    protected int calculate(int first, int second) {
        int value = first - second;
        if (first < 0 && second > 0 && value >= 0 || first >= 0 && second < 0 && value <= 0) {
            throw new SubtractOverflowException("overflow");
        }
        return first - second;
    }
}

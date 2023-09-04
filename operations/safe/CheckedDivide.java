package operations.safe;

import exceptions.overflow.DivideOverflowException;
import exceptions.DivisionByZeroException;
import expression.Expression;
import operations.unsafe.Divide;

public class CheckedDivide extends Divide {
    public CheckedDivide(Expression firstEx, Expression secondEx) {
        super(firstEx, secondEx);
    }
    @Override
    protected int calculate(int first, int second) {
        if (second == 0) {
            throw new DivisionByZeroException("Division by zero in " + first + " / " + second);
        }
        int value = first / second;
        if (first < 0 && second < 0 && value < 0) {
            throw new DivideOverflowException("overflow");
        }
        return value;
    }
}

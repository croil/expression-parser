package operations.safe;

import exceptions.overflow.AddOverflowException;
import expression.Expression;
import operations.unsafe.Add;

public class CheckedAdd extends Add {
    public CheckedAdd(Expression firstEx, Expression secondEx) {
        super(firstEx, secondEx);
    }

    @Override
    protected int calculate(int first, int second) {
        int adder = first + second;
        if (first > 0 && second > 0 && adder <= 0 || first < 0 && second < 0 && adder >= 0) {
            throw new AddOverflowException(first + " + " + second);
        }
        return first + second;
    }
}

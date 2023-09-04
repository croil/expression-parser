package operations.safe;

import exceptions.FunctionParsingException;
import expression.Expression;
import operations.unsafe.Max;

public class CheckedMax extends Max {

    public CheckedMax(char prefix, Expression first, char postfix, Expression second) {
        super(first, second);
        if (Character.isDigit(prefix) || Character.isLetter(postfix)) {
            throw new FunctionParsingException("Illegal max use");
        }
    }
    @Override
    protected int calculate(int first, int second) {
        return Math.max(first, second);
    }

}

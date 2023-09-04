package operations.unsafe;


import expression.Expression;

public class Const implements Expression {
    private final int constValue;

    public Const(int value) {
        constValue = value;
    }

    @Override
    public int evaluate(int x, int y, int z) {
        return this.constValue;
    }

    @Override
    public int evaluate(int x) {
        return this.constValue;
    }

    @Override
    public String toString() {
        return Integer.toString(constValue);
    }

    @Override
    public boolean equals(Object object) {
        return object != null && object.getClass() == getClass() && constValue == ((Const) object).constValue;
    }

    @Override
    public int hashCode() {
        return constValue;
    }

}

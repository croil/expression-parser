package operations.unsafe;

import expression.Expression;

import java.util.Objects;

public class Variable implements Expression {

    private final String variable;


    public Variable(String variable) {
        this.variable = variable;
    }

    @Override
    public int evaluate(int x, int y, int z) {
        if (variable.equals("x")) {
            return x;
        }
        if (variable.equals("y")) {
            return y;
        }
        if (variable.equals("z")) {
            return z;
        } else {
            throw new AssertionError();
        }
    }

    @Override
    public int evaluate(int x) {
        return x;
    }

    @Override
    public String toString() {
        return variable;
    }

    @Override
    public boolean equals(Object object) {
        return object != null && object.getClass() == getClass()
                && Objects.equals(variable, ((Variable) object).variable);
    }

    @Override
    public int hashCode() {
        return variable.hashCode();
    }

}

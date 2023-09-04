package parser;

import expression.Expression;


@FunctionalInterface
public interface Parser {
    Expression parse(String expression);
}

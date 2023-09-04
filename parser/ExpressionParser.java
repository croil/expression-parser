package parser;

import exceptions.FunctionParsingException;
import exceptions.ParsingException;
import expression.Expression;
import operations.safe.*;
import operations.unsafe.L0;
import operations.unsafe.T0;
import operations.unsafe.Variable;


public class ExpressionParser implements Parser {
    private String expression;

    private static final char END = '\0';
    private int pos = 0;
    private boolean currentUnary = false;


    public Expression parse(String expression) throws ParsingException {
        this.expression = expression;
        pos = 0;
        return addition();
    }

    private char getCurrent() {
        if (pos == expression.length()) {
            return END;
        }
        return expression.charAt(pos);
    }

    private char next() {
        char ch = getCurrent();
        if (ch == END) {
            return END;
        } else {
            pos++;
            return ch;
        }
    }

    private void skipWS() {
        while (Character.isWhitespace(getCurrent())) {
            pos++;
        }
    }


    public LexemeType nextLexeme() {
        skipWS();
        char ch = next();
        switch (ch) {
            case '+':
                return LexemeType.PLUS;
            case '-':
                return LexemeType.MINUS;
            case '*':
                return LexemeType.MUL;
            case '/':
                return LexemeType.DIV;
            case '(':
                return LexemeType.LEFT_BRACKET;
            case ')':
                return LexemeType.RIGHT_BRACKET;
            case 't':
                return LexemeType.T0;
            case 'l':
                return LexemeType.L0;
            case 'm':
                switch (next()) {
                    case 'i' -> {
                        pos += 1;
                        return LexemeType.MIN;
                    }
                    case 'a' -> {
                        pos += 1;
                        return LexemeType.MAX;
                    }
                    default -> throw new FunctionParsingException("Error while parsing min/max function on a position: " + pos);
                }
            case 'c':
                pos += 4;
                return LexemeType.COUNT;
            case END:
                return LexemeType.EOF;
            default:
                pos--;
                if ('x' <= ch && ch <= 'z') {
                    return LexemeType.VARIABLE;
                }
                if (Character.isDigit(ch)) {
                    return LexemeType.NUMBER;
                }
                throw new ParsingException("Parsing error on the position: " + pos);
        }
    }


    private Expression expression() {
        currentUnary = false;
        skipWS();
        return addition();
    }

    private Expression addition() {
        skipWS();
        Expression value = multiply();
        while (true) {
            switch (nextLexeme()) {
                case PLUS -> value = new CheckedAdd(value, multiply());
                case MINUS -> value = new CheckedSubtract(value, multiply());
                default -> {
                    pos--;
                    return value;
                }
            }
        }
    }

    public Expression multiply() {
        skipWS();
        Expression value = trivial();
        skipWS();
        char prefix = pos < expression.length() ? expression.charAt(pos - 1) : ' ';
        while (true) {
            switch (nextLexeme()) {
                case MUL -> value = new CheckedMultiply(value, trivial());
                case DIV -> value = new CheckedDivide(value, trivial());
                case MIN -> value = new CheckedMin(prefix, value, expression.charAt(pos), trivial());
                case MAX -> value = new CheckedMax(prefix, value, expression.charAt(pos), trivial());
                case NUMBER -> throw new ParsingException("Found two numbers in a row on a position: " + pos);
                default -> {
                    pos--;
                    return value;
                }
            }
        }
    }

    public Expression createNumber() {
        StringBuilder number = new StringBuilder();
        while (Character.isDigit(getCurrent())) {
            number.append(next());
        }
        if (currentUnary) {
            return new CheckedConst(Integer.parseInt("-" + number));
        }
        return new CheckedConst(Integer.parseInt(number.toString()));
    }

    public Expression trivial() {
        skipWS();
        switch (nextLexeme()) {
            case NUMBER -> {
                return createNumber();
            }
            case MINUS -> {
                currentUnary = true;
                Expression value = trivial();
                if (currentUnary) {
                    currentUnary = false;
                    return value;
                } else {
                    return new CheckedNegate(value);
                }
            }
            case VARIABLE -> {
                currentUnary = false;
                return new Variable(Character.toString(next()));
            }
            case T0 -> {
                pos++;
                currentUnary = false;
                return new T0(trivial());
            }
            case L0 -> {
                pos++;
                currentUnary = false;
                return new L0(trivial());
            }
            case LEFT_BRACKET -> {
                Expression expr = expression();
                if (nextLexeme() == LexemeType.RIGHT_BRACKET) {
                    return expr;
                } else {
                    throw new ParsingException("An error in the arrangement of brackets in the expression:" +
                            " Expected right bracket");
                }
            }
            default -> throw new ParsingException("Unknown error while parsing expression");
        }
    }
}
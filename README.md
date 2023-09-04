# Arithmetic Expression Parser

An arithmetic parser that evaluates expression with recursive-descent method. The parser supports various operations, left and right brackets and some math functions. It can be easily integrated into custom calculators.
A lot of operations will be added in foreseeable future
### Installing
* Download [parser.jar](parser.jar)
or
* Clone the repository `git clone https://github.com/croil/expression-parser`

### Executing program
```
java -jar parser.jar
```

## How it works
We parse our expression into terms, terms into factors and factorst into other expression, variables and constants.
It parses the following grammar
```
Expr –> Expr + Term | Term 
Term –> Term * Factor | Factor 
Factor –> ( Expr ) | id
```
**Time complexity:** **O(n)**

## Operations and operands
1. `+`
2. `-`
3. `*`
4. `/`
5. `L0` - number of leading zeros
6. `T0` - number of trailing zeros
7. `min/max` - minimum and maximum between two numbers
8. `Constants and variables` - any numbers and variables `x, y, z`


## Usage
```Java
final Parser parser = new ExpressionParser();
final String expression = "2 + 3*(x - y) + 3 max y";
final int result = parser.parse(expression).evaluate(1, 2, 3) // Answer is 2
```
## License

This project is licensed under the MIT License - see the LICENSE.md file for details


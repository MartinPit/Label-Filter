package cz.muni.fi.pb162.hw02.impl;

import cz.muni.fi.pb162.hw02.LabelMatcher;
import cz.muni.fi.pb162.hw02.error.InvalidExpressionException;
import cz.muni.fi.pb162.hw02.LabelFilter;

/**
 * Factory for matcher production
 */
public final class LabeledOperations {

    private LabeledOperations() {
        // intentionally private
    }

    /**
     * Produces instance of your {@link LabelMatcher} implementation
     * which matches based on given expression.
     *
     * @param expression expression for which the matcher is created
     * @throws InvalidExpressionException if expression is not valid
     * @return expression-based label matcher
     */
    public static LabelMatcher expressionMatcher(String expression) {
        throwIfEmpty(expression);

        ExpressionParser parser = new Parser(expression);
        parser.parse();
        return new Matcher(parser.getExpressions(), parser.getOperators());
    }

    /**
     * Produces instance of your {@link LabelFilter} implementation
     * which filters based on given expression.
     *
     * @param expression expression for which the filter is created
     * @throws InvalidExpressionException if expression is not valid
     * @return expression-based label filter
     */
    public static LabelFilter expressionFilter(String expression) {
        throwIfEmpty(expression);

        ExpressionParser parser = new Parser(expression);
        parser.parse();
        return new Filter(parser.getExpressions(), parser.getOperators());
    }

    /**
     *
     * Utility method that throws an exception if string
     * is empty.
     *
     * @param input string to check
     * @throws InvalidExpressionException if string is empty
     */
    private static void throwIfEmpty(String input) {
        if (input.length() == 0) {
            throw new InvalidExpressionException(input);
        }
    }
}

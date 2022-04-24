package cz.muni.fi.pb162.hw02.impl;

import cz.muni.fi.pb162.hw02.LabelMatcher;
import cz.muni.fi.pb162.hw02.error.InvalidExpressionException;
import cz.muni.fi.pb162.hw02.LabelFilter;

import java.util.Set;

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
        ExpressionParser parser = new Parser(expression);
        Set<LabelExpression> conditions = parser.parse();

        if (conditions == null) {
            throw new InvalidExpressionException(expression);
        }

        return new Matcher(conditions);
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
        ExpressionParser parser = new Parser(expression);
        Set<LabelExpression> conditions = parser.parse();

        if (conditions == null) {
            throw new InvalidExpressionException(expression);
        }

        return new Filter(conditions);
    }
}

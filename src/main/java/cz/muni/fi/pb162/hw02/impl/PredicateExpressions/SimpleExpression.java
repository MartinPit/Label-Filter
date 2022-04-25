package cz.muni.fi.pb162.hw02.impl.PredicateExpressions;

import java.util.function.Predicate;

/**
 * @author Martin Oliver Pitonak
 */
public class SimpleExpression implements Predicate<String> {

    private final String expression;
    private boolean negation;

    public SimpleExpression(String expression) {
        this.expression = expression;
        negation = false;
    }
    @Override
    public boolean test(String s) {
        return s.equals(expression);
    }

    public void makeNegative() {
        negation = true;
    }

    @Override
    public String toString() {
        if (negation) {
            return "!" + expression;
        }
        return expression;
    }
}

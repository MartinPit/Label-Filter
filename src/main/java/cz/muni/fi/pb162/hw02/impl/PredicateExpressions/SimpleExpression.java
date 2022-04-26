package cz.muni.fi.pb162.hw02.impl.PredicateExpressions;

import java.util.function.Predicate;

/**
 * @author Martin Oliver Pitonak
 */
public class SimpleExpression implements Predicate<Iterable<String>> {

    private final String expression;
    private boolean negation;

    public SimpleExpression(String expression) {
        this.expression = expression;
        negation = false;
    }
    @Override
    public boolean test(Iterable<String> labels) {
        for (String label : labels) {
            if (label.equals(expression)) {
                return !negation;
            }
        }
        return negation;
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

package cz.muni.fi.pb162.hw02.impl;

import java.util.Set;
import java.util.function.Predicate;

/**
 *
 * Represents an expression that can be compared against a Set of labels.
 *
 * @author Martin Oliver Pitonak
 */
public class Expression implements Predicate<Set<String>> {

    private final String expression;
    private boolean negation;

    /**
     *
     * Constructs an expression out of the given string that can be
     * compared to different labels later.
     *
     * @param expression
     */
    public Expression(String expression) {
        this.expression = expression;
        negation = false;
    }

    /**
     *
     * Negates the expression.
     *
     */
    public void makeNegative() {
        negation = true;
    }

    /**
     *
     * Tests the expression against the set of given labels.
     *
     * @param labels the set of labels
     * @return true if expression matches, false otherwise
     */
    public boolean test(Set<String> labels) {
        for (String label : labels) {
            if (label.equals(expression)) {
                return !negation;
            }
        }
        return negation;
    }
    @Override
    public String toString() {
        if (negation) {
            return ("!" + expression);
        }
        return expression;
    }
}

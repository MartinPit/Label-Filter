package cz.muni.fi.pb162.hw02.impl.PredicateExpressions;

/**
 * @author Martin Oliver Pitonak
 */
public class SimpleExpression implements LabelExpression{

    private final String expression;
    private boolean negation;

    /**
     *
     * Construct a new expression predicate based on the given string
     *
     * @param expression String to be used as expression
     */
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

    /**
     *
     * Negates the expression
     *
     */
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

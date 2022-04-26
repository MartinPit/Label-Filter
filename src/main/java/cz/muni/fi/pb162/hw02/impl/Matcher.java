package cz.muni.fi.pb162.hw02.impl;

import cz.muni.fi.pb162.hw02.HasLabels;
import cz.muni.fi.pb162.hw02.LabelMatcher;
import cz.muni.fi.pb162.hw02.impl.PredicateExpressions.Operator;
import cz.muni.fi.pb162.hw02.impl.PredicateExpressions.SimpleExpression;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Martin Oliver Pitonak
 */
public class Matcher implements LabelMatcher {

    private final List<SimpleExpression> expressions;
    private final List<Operator> operators;

    /**
     *
     * Constructs a {@link LabelMatcher}, which matches label items
     * according to the expressions given
     *
     * @param expressions expressions to match by
     */
    public Matcher(List<SimpleExpression> expressions, List<Operator> operators) {
        this.expressions = new ArrayList<>(expressions);
        this.operators = new ArrayList<>(operators);
    }

    @Override
    public boolean matches(HasLabels labeled) {
        List<Boolean> evaluatedExpressions = evaluateExpressions(labeled);

        if (operators.size() == 0) {
            return evaluatedExpressions.get(0);
        }
        boolean lastResult = operators.get(0).useOperator(evaluatedExpressions.get(0),
                                                           evaluatedExpressions.get(1));

        for (int i = 1; i < operators.size(); i++) {
            Operator op = operators.get(i);
            lastResult = op.useOperator(lastResult, evaluatedExpressions.get(i + 1));
        }
        return lastResult;
    }

    @Override
    public boolean all(Iterable<HasLabels> labeled) {
        for (HasLabels item : labeled) {
            if (! matches(item)) {
                System.out.println("Doesn't match:" + item);
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean any(Iterable<HasLabels> labeled) {
        for (HasLabels item : labeled) {
            if (matches(item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean none(Iterable<HasLabels> labeled) {
        for (HasLabels item : labeled) {
            if (matches(item)) {
                return false;
            }
        }
        return true;
    }

    private List<Boolean> evaluateExpressions(HasLabels labeled) {
        return expressions.stream()
                .map(e -> e.test(labeled.getLabels()))
                .collect(Collectors.toList());
    }
}

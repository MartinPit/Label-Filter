package cz.muni.fi.pb162.hw02.impl;

import cz.muni.fi.pb162.hw02.impl.PredicateExpressions.Operator;
import cz.muni.fi.pb162.hw02.impl.PredicateExpressions.SimpleExpression;

import java.util.List;
import java.util.Set;

/**
 * @author Martin Oliver Pitonak
 */
public interface ExpressionParser {

    /**
     *
     * Parses the expression given to it in its constructor.
     *
     * @return set of {@link ExpressionGroup}
     */
    void parse();


    List<SimpleExpression> getExpressions();

    List<Operator> getOperators();
}

package cz.muni.fi.pb162.hw02.impl;

import cz.muni.fi.pb162.hw02.impl.PredicateExpressions.LabelExpression;
import cz.muni.fi.pb162.hw02.impl.PredicateExpressions.Operator;

import java.util.List;

/**
 *
 * Parser which parses the expression input string
 *
 * @author Martin Oliver Pitonak
 */
public interface ExpressionParser {

    /**
     *
     * Checks and parses the given string and stores
     * the parsed representation into its attributes.
     *
     */
    void parse();

    /**
     *
     * Returns expressions saved in its attribute
     *
     * @return list of {@link LabelExpression}
     */
    List<LabelExpression> getExpressions();

    /**
     *
     * Returns operators saved in its attribute
     *
     * @return list of {@link Operator}
     */
    List<Operator> getOperators();
}

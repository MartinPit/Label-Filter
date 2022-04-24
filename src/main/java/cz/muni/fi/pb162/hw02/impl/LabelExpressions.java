package cz.muni.fi.pb162.hw02.impl;

import java.util.Set;
import java.util.function.Predicate;

/**
 *
 * Interface for a set of expressions saved as predicates.
 *
 * @author Martin Oliver Pitonak
 */
public interface LabelExpressions {

    /**
     *
     * Adds a single expression to the set.
     *
     * @param expression expression to add
     * @return true if adding was successful, false otherwise
     */
    boolean addExpression(String expression, boolean negation);

    /**
     *
     * Evaluates the expressions against the given set of labels.
     *
     * @param labels labels to evaluate to expression
     * @return true if the expression matches, false otherwise
     */
    boolean checkMatch(Set<String> labels);
}

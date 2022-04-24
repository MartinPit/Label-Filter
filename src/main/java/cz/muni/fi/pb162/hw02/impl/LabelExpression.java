package cz.muni.fi.pb162.hw02.impl;

import cz.muni.fi.pb162.hw02.HasLabels;

import java.util.function.Predicate;

/**
 *
 * Interface for a set of expressions saved as predicates.
 *
 * @author Martin Oliver Pitonak
 */
public interface LabelExpression {


    /**
     *
     * Get the expression on the index-th position.
     *
     * @param index position of desired expression
     * @return the copy expression
     */
    Predicate<String> getExpression(int index);

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
     * Returns the amount of expressions.
     *
     * @return the length of the list of expressions
     */
    int amount();

    /**
     *
     * Evaluates the expression on the index-th position against the given item.
     *
     * @param index position of the expression in the list
     * @param item item to evaluate to
     * @return true if the expression matches, false otherwise
     */
    boolean evaluate(int index, HasLabels item);
}

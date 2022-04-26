package cz.muni.fi.pb162.hw02.impl.PredicateExpressions;

import java.util.function.Predicate;

/**
 *
 * Represents an expression used to determine if the labeled
 * object matches
 *
 * @author Martin Oliver Pitonak
 */
public interface LabelExpression extends Predicate<Iterable<String>> {

    /**
     *
     * Tests the expression against the labels provided
     * to it
     *
     * @param strings {@link Iterable} of String labels
     * @return true if expression matches, false otherwise
     */
    @Override
    boolean test(Iterable<String> strings);

    /**
     *
     * Negates the expression.
     *
     */
    void makeNegative();
}

package cz.muni.fi.pb162.hw02.impl.PredicateExpressions;

/**
 *
 * Represent an expression operator used to compare 2 boolean values.
 *
 * @author Martin Oliver Pitonak
 */
public interface Operator {

    /**
     *
     * Uses the operator of the saved type on the given boolean values.
     *
     * @param fst first boolean to use
     * @param snd second boolean to use
     * @return new boolean value based on the result of the operator
     *         applied to the given two arguments
     */
    boolean useOperator(boolean fst, boolean snd);
}

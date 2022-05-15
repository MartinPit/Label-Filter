package cz.muni.fi.pb162.hw02.impl.PredicateExpressions;

/**
 *
 * Represents "&" expression operator.Represents "&" expression operator.
 *
 * @author Martin Oliver Pitonak
 */
public class OperatorAnd implements Operator {

    /**
     *
     * Constructs a new "&" operator
     *
     */
    public OperatorAnd() {

    }

    @Override
    public boolean useOperator(boolean fst, boolean snd) {
        return fst && snd;
    }
}

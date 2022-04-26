package cz.muni.fi.pb162.hw02.impl.PredicateExpressions;

/**
 * @author Martin Oliver Pitonak
 */
public class OperatorOr implements Operator {

    /**
     *
     * Constructs a new "|" operator
     *
     */
    public OperatorOr() {}

    @Override
    public boolean useOperator(boolean fst, boolean snd) {
        return fst || snd;
    }

    @Override
    public String toString() {
        return "|";
    }
}

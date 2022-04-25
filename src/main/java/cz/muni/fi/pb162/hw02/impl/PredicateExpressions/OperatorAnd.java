package cz.muni.fi.pb162.hw02.impl.PredicateExpressions;

/**
 * @author Martin Oliver Pitonak
 */
public class OperatorAnd implements Operator {

    public OperatorAnd() {

    }

    @Override
    public boolean useOperator(boolean fst, boolean snd) {
        return false;
    }

    @Override
    public String toString() {
        return "&";
    }
}

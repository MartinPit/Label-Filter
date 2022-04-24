package cz.muni.fi.pb162.hw02.impl;

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
    Set<LabelExpression> parse();
}

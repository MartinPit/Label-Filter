package cz.muni.fi.pb162.hw02.impl;

import cz.muni.fi.pb162.hw02.HasLabels;
import cz.muni.fi.pb162.hw02.LabelMatcher;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Martin Oliver Pitonak
 */
public class Matcher implements LabelMatcher {

    private final Set<ExpressionGroup> expression;

    public Matcher(Set<ExpressionGroup> expression) {
        this.expression = new HashSet<>(expression);
    }

    @Override
    public boolean matches(HasLabels labeled) {
        return false;
    }

    @Override
    public boolean all(Iterable<HasLabels> labeled) {
        return false;
    }

    @Override
    public boolean any(Iterable<HasLabels> labeled) {
        return false;
    }

    @Override
    public boolean none(Iterable<HasLabels> labeled) {
        return false;
    }
}

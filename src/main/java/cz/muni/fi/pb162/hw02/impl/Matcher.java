package cz.muni.fi.pb162.hw02.impl;

import cz.muni.fi.pb162.hw02.HasLabels;
import cz.muni.fi.pb162.hw02.LabelMatcher;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

/**
 * @author Martin Oliver Pitonak
 */
public class Matcher implements LabelMatcher {

    private final Set<Set<Predicate<String>>> expression;

    public Matcher(Set<Set<Predicate<String>>> expression) {
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

package cz.muni.fi.pb162.hw02.impl;

import cz.muni.fi.pb162.hw02.HasLabels;
import cz.muni.fi.pb162.hw02.LabelFilter;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

/**
 * @author Martin Oliver Pitonak
 */
public class Filter implements LabelFilter {

    private final Set<ExpressionGroup> expression;

    public Filter(Set<ExpressionGroup> expression) {
        this.expression = new HashSet<>(expression);
    }
    @Override
    public Collection<HasLabels> matching(Iterable<HasLabels> labeled) {
        return null;
    }

    @Override
    public Collection<HasLabels> notMatching(Iterable<HasLabels> labeled) {
        return null;
    }

    @Override
    public Collection<HasLabels> joined(Iterable<HasLabels> fst, Iterable<HasLabels> snd) {
        return null;
    }

    @Override
    public Collection<HasLabels> distinct(Iterable<HasLabels> fst, Iterable<HasLabels> snd) {
        return null;
    }

    @Override
    public Collection<HasLabels> intersection(Iterable<HasLabels> fst, Iterable<HasLabels> snd) {
        return null;
    }
}

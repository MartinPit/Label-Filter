package cz.muni.fi.pb162.hw02.impl;

import cz.muni.fi.pb162.hw02.HasLabels;
import cz.muni.fi.pb162.hw02.LabelFilter;
import cz.muni.fi.pb162.hw02.LabelMatcher;
import cz.muni.fi.pb162.hw02.impl.utils.SetUtils;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Martin Oliver Pitonak
 */
public class Filter implements LabelFilter {

    private final LabelMatcher matcher;

    /**
     *
     * Constructs a {@link LabelFilter}, which filters label items
     * according to the expressions given
     *
     * @param expressions expressions to filter by
     */
    public Filter(Set<LabelExpressions> expressions) {
        this.matcher = new Matcher(expressions);
    }
    @Override
    public Collection<HasLabels> matching(Iterable<HasLabels> labeled) {
        Set<HasLabels> matchedItems = new HashSet<>();

        for (HasLabels item : labeled) {
            if (matcher.matches(item)) {
                matchedItems.add(item);
            }
        }
        return matchedItems;
    }

    @Override
    public Collection<HasLabels> notMatching(Iterable<HasLabels> labeled) {
        Set<HasLabels> matchedItems = new HashSet<>();

        for (HasLabels item : labeled) {
            if (! matcher.matches(item)) {
                matchedItems.add(item);
            }
        }
        return matchedItems;
    }

    @Override
    public Collection<HasLabels> joined(Iterable<HasLabels> fst, Iterable<HasLabels> snd) {
        Set<HasLabels> fstMatched = new HashSet<>(matching(fst));
        Set<HasLabels> sndMatched = new HashSet<>(matching(snd));
        return SetUtils.union(fstMatched, sndMatched);
    }

    @Override
    public Collection<HasLabels> distinct(Iterable<HasLabels> fst, Iterable<HasLabels> snd) {
        Set<HasLabels> fstMatched = new HashSet<>(matching(fst));
        Set<HasLabels> sndMatched = new HashSet<>(matching(snd));
        fstMatched.removeAll(sndMatched);
        sndMatched.removeAll(fstMatched);
        return SetUtils.union(fstMatched, sndMatched);
    }

    @Override
    public Collection<HasLabels> intersection(Iterable<HasLabels> fst, Iterable<HasLabels> snd) {
        Set<HasLabels> fstMatched = new HashSet<>(matching(fst));
        Set<HasLabels> sndMatched = new HashSet<>(matching(snd));
        fstMatched.retainAll(sndMatched);
        return fstMatched;
    }
}

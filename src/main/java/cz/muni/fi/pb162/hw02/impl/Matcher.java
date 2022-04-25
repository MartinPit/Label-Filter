package cz.muni.fi.pb162.hw02.impl;

import cz.muni.fi.pb162.hw02.HasLabels;
import cz.muni.fi.pb162.hw02.LabelMatcher;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Martin Oliver Pitonak
 */
public class Matcher implements LabelMatcher {

    private final Set<LabelExpressions> expressions;

    /**
     *
     * Constructs a {@link LabelMatcher}, which matches label items
     * according to the expressions given
     *
     * @param expressions expressions to match by
     */
    public Matcher(Set<LabelExpressions> expressions) {
        System.out.println(expressions);
        this.expressions = new HashSet<>(expressions);
    }

    @Override
    public boolean matches(HasLabels labeled) {
        Set<String> labels = labeled.getLabels();

        for (LabelExpressions group : expressions) {
            if (group.checkMatch(labels)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean all(Iterable<HasLabels> labeled) {
        for (HasLabels item : labeled) {
            if (! matches(item)) {
                System.out.println("Doesn't match:" + item);
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean any(Iterable<HasLabels> labeled) {
        for (HasLabels item : labeled) {
            if (matches(item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean none(Iterable<HasLabels> labeled) {
        for (HasLabels item : labeled) {
            if (matches(item)) {
                return false;
            }
        }
        return true;
    }
}

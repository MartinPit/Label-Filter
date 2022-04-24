package cz.muni.fi.pb162.hw02.impl;

import cz.muni.fi.pb162.hw02.HasLabels;

import java.util.Collection;
import java.util.HashSet;
import java.util.function.Predicate;

/**
 *
 * Saves a group of predicates which all have to be true
 * for an object to match
 *
 * @author Martin Oliver Pitonak
 */
public class ExpressionGroup implements LabelExpression {

    private Collection<Predicate<String>> expressions;

    public ExpressionGroup() {
        expressions = new HashSet<>();
    }

    @Override
    public Predicate<String> getExpression(int index) {
        return null;
    }

    public boolean addExpression(String expression) {
        return false;
    }

    @Override
    public int amount() {
        return 0;
    }

    @Override
    public boolean evaluate(int index, HasLabels item) {
        return false;
    }
}

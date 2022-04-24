package cz.muni.fi.pb162.hw02.impl;

import cz.muni.fi.pb162.hw02.impl.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

/**
 *
 * Saves a group of predicates which all have to be true
 * for an object to match
 *
 * @author Martin Oliver Pitonak
 */
public class ExpressionGroup implements LabelExpressions {

    private List<Predicate<String>> expressions;

    public ExpressionGroup() {
        expressions = new ArrayList<>();
    }

    @Override
    public boolean addExpression(String expression, boolean negation) {
        if (! checkIfAlphaNumeric(expression)) {
            return false;
        }

        Predicate<String> predicate = s -> s.equals(expression);

        if (negation) {
            predicate = predicate.negate();
        }
        expressions.add(predicate);

        return true;
    }

    @Override
    public boolean checkMatch(Set<String> labels) {
        for (Predicate<String> predicate : expressions) {
            if (! checkAgainstPredicate(predicate, labels)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkAgainstPredicate(Predicate<String> predicate, Set<String> labels) {
        for (String label : labels) {
            if (predicate.test(label)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkIfAlphaNumeric(String input) {

        String onlyAlphaNumeric = StringUtils.takeWhile(input, Character::isLetterOrDigit);

        return onlyAlphaNumeric.length() == input.length();
    }
}

package cz.muni.fi.pb162.hw02.impl;

import cz.muni.fi.pb162.hw02.HasLabels;
import cz.muni.fi.pb162.hw02.impl.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 *
 * Saves a group of predicates which all have to be true
 * for an object to match
 *
 * @author Martin Oliver Pitonak
 */
public class ExpressionGroup implements LabelExpression {

    private List<Predicate<String>> expressions;

    public ExpressionGroup() {
        expressions = new ArrayList<>();
    }

    @Override
    public Predicate<String> getExpression(int index) {

        if (index < 0 || index >= expressions.size()) {
            return null;
        }

        return expressions.get(index);
    }

    @Override
    public boolean addExpression(String expression, boolean negation) {
        if (! checkIfAlphaNumeric(expression)) {
            return false;
        }

        Predicate<String> predicate = s -> s.equals(expression);

        if (negation) {
            System.out.printf("negative ");
            predicate = predicate.negate();
        }

        System.out.println(expression);
        expressions.add(predicate);

        return true;
    }

    @Override
    public int amount() {
        return expressions.size();
    }

    @Override
    public boolean evaluate(int index, HasLabels item) {
        return false;
    }

    private boolean checkIfAlphaNumeric(String input) {

        String onlyAlphaNumeric = StringUtils.takeWhile(input, Character::isLetterOrDigit);

        return onlyAlphaNumeric.length() == input.length();
    }

    @Override
    public String toString() {
        return "ExpressionGroup{" +
                "expressions=" + expressions +
                '}';
    }
}

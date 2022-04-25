package cz.muni.fi.pb162.hw02.impl;

import cz.muni.fi.pb162.hw02.impl.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 *
 * Saves a group of predicates which all have to be true
 * for an object to match
 *
 * @author Martin Oliver Pitonak
 */
public class ExpressionGroup implements LabelExpressions {

    private List<Expression> expressions;

    /**
     *
     * Constructs and empty set of expressions
     *
     */
    public ExpressionGroup() {
        expressions = new ArrayList<>();
    }

    @Override
    public boolean addExpression(String expression, boolean negation) {
        if (! checkIfAlphaNumeric(expression)) {
            return false;
        }

        Expression predicate = new Expression(expression);

        if (negation) {
            predicate.makeNegative();
        }
        expressions.add(predicate);

        return true;
    }

    @Override
    public boolean checkMatch(Set<String> labels) {
        int matchingExpressions = 0;

        for (Expression e : expressions) {
            if (e.test(labels)) {
                matchingExpressions++;
            }
        }

        return matchingExpressions == expressions.size();
    }

    private boolean checkIfAlphaNumeric(String input) {

        String onlyAlphaNumeric = StringUtils.takeWhile(input, Character::isLetterOrDigit);

        return onlyAlphaNumeric.length() == input.length();
    }

    @Override
    public String toString() {
        String returnString = "";
        for (Expression e : expressions) {
            returnString += e;
            returnString += '\n';
        }
        return returnString;
    }
}

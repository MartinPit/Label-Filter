package cz.muni.fi.pb162.hw02.impl;


import cz.muni.fi.pb162.hw02.error.InvalidExpressionException;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Martin Oliver Pitonak
 */
public class Parser implements ExpressionParser {

    private final String originalInput;

    public Parser(String expression) {
        originalInput = expression;
    }

    public Set<ExpressionGroup> parse() {
        String input = originalInput;
        Set<ExpressionGroup> conditions = new HashSet<>();
        input = input.trim();
        throwIfInvalid(input);

        String[] parts = input.trim().split("\\|");

        for (String part : parts) {
            ExpressionGroup condition = checkAndSplitByAnd(part);
            conditions.add(condition);
        }

        return conditions;
    }

    private ExpressionGroup checkAndSplitByAnd(String input) {
        LabelExpression group = new ExpressionGroup();
        input = input.trim();
        throwIfInvalid(input);
        return null;
    }

    private void throwIfInvalid(String input) throws InvalidExpressionException {

        if (input.length() == 0) {
            throw new InvalidExpressionException(originalInput);
        }

        if (input.charAt(0) == '|' || input.charAt(0) == '&') {
            throw new InvalidExpressionException(originalInput);
        }

        if (input.charAt(input.length() - 1) == '|' || input.charAt(input.length() - 1) == '&') {
            throw new InvalidExpressionException(originalInput);
        }
    }
}

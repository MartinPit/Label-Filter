package cz.muni.fi.pb162.hw02.impl;


import cz.muni.fi.pb162.hw02.error.InvalidExpressionException;
import cz.muni.fi.pb162.hw02.impl.utils.StringUtils;

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

    public Set<LabelExpressions> parse() {
        String input = originalInput;
        Set<LabelExpressions> conditions = new HashSet<>();
        input = input.trim();
        throwIfInvalid(input);

        String[] parts = input.split("\\|");

        for (String part : parts) {
            LabelExpressions condition = checkAndSplitByAnd(part);
            conditions.add(condition);
        }

        return conditions;
    }

    private LabelExpressions checkAndSplitByAnd(String input) {
        LabelExpressions group = new ExpressionGroup();
        boolean negation = false;
        input = input.trim();
        throwIfInvalid(input);

        String[] parts = input.split("&");

        for (String part : parts) {
            part = part.trim();
            throwIfInvalid(part);

            int bangCount = StringUtils.countSubsequentChars(part, '!', 0);
            if (bangCount % 2 != 0) {
                negation = true;
            }

            if (! group.addExpression(part.substring(bangCount), negation)) {
                throw new InvalidExpressionException(originalInput);
            }
        }

        return group;
    }

    private void throwIfInvalid(String input) throws InvalidExpressionException {

        if (input.length() == 0) {
            throw new InvalidExpressionException(originalInput);
        }

        Character first = input.charAt(0);
        Character last = input.charAt(input.length() - 1);

        if (! Character.isLetterOrDigit(first)) {
            if (first != '!') {
                throw new InvalidExpressionException(originalInput);
            }
        }

        if (! Character.isLetterOrDigit(last)) {
            throw new InvalidExpressionException(originalInput);
        }
    }
}

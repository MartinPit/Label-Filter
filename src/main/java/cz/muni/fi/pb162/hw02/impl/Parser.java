package cz.muni.fi.pb162.hw02.impl;


import cz.muni.fi.pb162.hw02.error.InvalidExpressionException;
import cz.muni.fi.pb162.hw02.impl.PredicateExpressions.LabelExpression;
import cz.muni.fi.pb162.hw02.impl.PredicateExpressions.SimpleExpression;
import cz.muni.fi.pb162.hw02.impl.PredicateExpressions.Operator;
import cz.muni.fi.pb162.hw02.impl.PredicateExpressions.OperatorAnd;
import cz.muni.fi.pb162.hw02.impl.PredicateExpressions.OperatorOr;
import cz.muni.fi.pb162.hw02.impl.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Martin Oliver Pitonak
 */
public class Parser implements ExpressionParser {

    private final String originalInput;
    private final List<LabelExpression> parsedExpressions;
    private final List<Operator> parsedOperators;

    /**
     *
     * Constructs a parser that parses the given input
     *
     * @param input string to parse
     */
    public Parser(String input) {
        originalInput = input;
        parsedExpressions = new ArrayList<>();
        parsedOperators = new ArrayList<>();
    }

    public List<LabelExpression> getExpressions() {
        return parsedExpressions;
    }

    public List<Operator> getOperators() {
        return parsedOperators;
    }

    @Override
    public void parse() {
        String input = originalInput;
        input = input.trim();
        throwIfInvalid(input);

        String[] parts = input.split("\\|");
        for (String part : parts) {
            splitByAndParse(part);
            parsedOperators.add(new OperatorOr());
        }

        parsedOperators.remove(parsedOperators.size() - 1);
    }

    /**
     *
     * Helper method for parse, which splits the given string by "a"
     * a parses the smaller chunks.
     *
     * @param input input string
     */
    private void splitByAndParse(String input) {
        input = input.trim();
        throwIfInvalid(input);

        String[] parts = input.split("&");
        for (String part : parts) {
            saveExpression(part.trim());
            parsedOperators.add(new OperatorAnd());
        }
        parsedOperators.remove(parsedOperators.size() - 1);
    }

    /**
     *
     * Checks and saves the representation of the label expression into a
     * list of expressions.
     *
     * @param input expression to be saved
     */
    private void saveExpression(String input) {
        input = input.replaceAll("\\s+", "");
        int bangCount = StringUtils.countSubsequentChars(input, '!', 0);
        input = input.substring(bangCount);

        if (StringUtils.takeWhile(input, Character::isLetterOrDigit).length() != input.length()) {
            throw new InvalidExpressionException(originalInput);
        }

        LabelExpression expression = new SimpleExpression(input);
        if (bangCount % 2 == 1) {
            expression.makeNegative();
        }
        parsedExpressions.add(expression);
    }

    /**
     *
     * Utility method to check the validity of the input string
     *
     * @param input string to check
     * @throws InvalidExpressionException throws if not valid
     */
    private void throwIfInvalid(String input) throws InvalidExpressionException {

        if (input.length() == 0) {
            throw new InvalidExpressionException(originalInput);
        }

        char first = input.charAt(0);
        char last = input.charAt(input.length() - 1);

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


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

    /**
     *
     * Parses the string by dividing it into a Set
     * of
     *
     */
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
        System.out.println(parsedExpressions);
        System.out.println(parsedOperators);
    }

    private void splitByAndParse(String input) {
        input = input.trim();
        throwIfInvalid(input);

        String[] parts = input.split("&");
        for (String part : parts) {
            addExpression(part.trim());
            parsedOperators.add(new OperatorAnd());
        }
        parsedOperators.remove(parsedOperators.size() - 1);
    }

    private void addExpression(String input) throws InvalidExpressionException {
        int bangCount = StringUtils.countSubsequentChars(input, '!', 0);
        input = input.substring(bangCount);
        input = input.trim();

        if (StringUtils.takeWhile(input, Character::isLetterOrDigit).length() != input.length()) {
            throw new InvalidExpressionException(originalInput);
        }

        LabelExpression expression = new SimpleExpression(input);
        if (bangCount % 2 == 1) {
            expression.makeNegative();
        }
        parsedExpressions.add(expression);
    }

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


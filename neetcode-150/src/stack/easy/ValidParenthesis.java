package stack.easy;

import java.util.Stack;

public class ValidParenthesis {

    public void test() {
        var result1 = isValid("()");
        assert result1;

        var result2 = isValid("()[]{}");
        assert result2;

        var result3 = isValid("(]");
        assert !result3;

    }

    private boolean isValid(String s) {

        var stack = new Stack<Character>();

        for (Character c : s.toCharArray()) {
            if (isOpeningBracket(c)) {
                stack.push(c);
            } else if (isClosingBracket(c)) {
                if (!stack.isEmpty() && pairMatches(stack.peek(), c)) {
                    stack.pop();
                } else {
                    System.out.println(s + " is not valid. final stack = " + stack);
                    return false;
                }
            }
        }

        if (stack.isEmpty()) {
            System.out.println(s + " is valid. final stack = " + stack);
        } else {
            System.out.println(s + " is not valid. final stack = " + stack);
        }

        return stack.isEmpty();
    }

    private boolean pairMatches(Character openingBracket, Character closingBracket) {
        if (openingBracket.equals('(') && closingBracket.equals(')')) {
            return true;
        } else if (openingBracket.equals('[') && closingBracket.equals(']')) {
            return true;
        } else if (openingBracket.equals('{') && closingBracket.equals('}')) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isOpeningBracket(Character c) {
        return c.equals('(') || c.equals('[') || c.equals('{');
    }

    private boolean isClosingBracket(Character c) {
        return c.equals(')') || c.equals(']') || c.equals('}');
    }

    private boolean isValid2(String s) {

        var stack = new Stack<Character>();

        for (Character c : s.toCharArray()) {
            if (c.equals('(')) {
                stack.push(')');
            } else if (c.equals('[')) {
                stack.push(']');
            } else if (c.equals('{')) {
                stack.push('}');
            } else if (stack.isEmpty()) {
                return false;
            } else if (!stack.pop().equals(c)) {
                return false;
            }
        }

        return stack.isEmpty();

    }

}

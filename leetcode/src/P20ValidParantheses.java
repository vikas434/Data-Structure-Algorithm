import java.util.Stack;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 *     Open brackets must be closed by the same type of brackets.
 *     Open brackets must be closed in the correct order.
 *     Every close bracket has a corresponding open bracket of the same type.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "()"
 * Output: true
 *
 * Example 2:
 *
 * Input: s = "()[]{}"
 * Output: true
 *
 * Example 3:
 *
 * Input: s = "(]"
 * Output: false
 *
 *
 *
 * Constraints:
 *
 *     1 <= s.length <= 104
 *     s consists of parentheses only '()[]{}'.
 */
public class P20ValidParantheses {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (checkLeft(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty())
                    return false;
                if (!match(c, stack.pop())) {
                    return false;
                }
            }
        }
       return stack.isEmpty();
    }

    private boolean match(char c, char pop) {
        switch (pop) {
            case '{' -> {
                if (c == '}')
                    return true;
            }
            case '(' -> {
                if (c == ')')
                    return true;
            }
            case '[' -> {
                if (c == ']')
                    return true;
            }
        }
        return false;
    }

    private boolean checkLeft(char c) {
        return c == '(' || c == '{' || c == '[';
    }
}

import java.util.Stack;

public class Z4 {

    public static String solution(String s) {
        //return constructString(1, s);
        if (s.isEmpty()) {
            return "";
        }

        Stack<Character> stack = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
            } else if (matchingPair(c, stack.peek())) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }


        if (stack.isEmpty()) {
            return "";
        }

        // print stack opposite
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();


    }

    private static boolean matchingPair(Character c, Character peek) {
        if (c == 'A' && peek == 'B') {
            return true;
        } else if (c == 'B' && peek == 'A') {
            return true;
        } else if (c == 'C' && peek == 'D') {
            return true;
        } else if (c == 'D' && peek == 'C') {
            return true;
        } else {
            return false;
        }
    }

    // S -> 250,000
    private static String constructString(int i, String s) {
        if (s.length() == 0 || i == s.length()) {
            return s;
        }

        if ((s.charAt(i) == 'A' && s.charAt(i - 1) == 'B')
                || (s.charAt(i) == 'B' && s.charAt(i - 1) == 'A')
                || (s.charAt(i) == 'C' && s.charAt(i - 1) == 'D')
                || (s.charAt(i) == 'D' && s.charAt(i - 1) == 'C')) {

            return constructString(1, i > 1 ? s.substring(0, i - 1) + s.substring(i + 1) : s.substring(i + 1));
        }
        return constructString(i + 1, s);
    }


    public static void main(String[] args) {
        System.out.println(solution("CBACDD"));
    }
}

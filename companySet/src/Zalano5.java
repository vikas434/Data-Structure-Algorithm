import java.util.Stack;

public class Zalano5 {

    public static String solution(String s) {
        Stack<Character> st = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == 'a' && !st.isEmpty()){
                if(st.peek() == 'b'){
                    st.pop();
                    continue;
                }
            }
            if(c == 'b' && !st.isEmpty()){
                if(st.peek() == 'a'){
                    st.pop();
                    continue;
                }
            }
            if(c == 'c' && !st.isEmpty()){
                if(st.peek() == 'd'){
                    st.pop();
                    continue;
                }
            }
            if(c == 'd' && !st.isEmpty()){
                if(st.peek() == 'c'){
                    st.pop();
                    continue;
                }
            }
            st.push(c);
        }

        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.insert(0, st.pop());
        }
        return sb.toString();


    }

    private static boolean matchingPair(Character c, Character peek) {
        if(c == 'A' && peek == 'B') {
            return true;
        } else if(c == 'B' && peek == 'A') {
            return true;
        } else if(c == 'C' && peek == 'D') {
            return true;
        } else return c == 'D' && peek == 'B';
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
        System.out.println(solution("dcbbcbacddaadc"));
    }
}

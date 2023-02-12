public class Zalano2 {

    public static String solution(String S) {
        // Implement your solution here

        if(S.isEmpty()) {
            return "";
        }

        StringBuilder sb = new StringBuilder(S);
        var current = 0;
        var next = 1;
        while (next <= sb.length()) {
            if(sb.charAt(current) == 'A' && sb.charAt(next) == 'B') {
                sb.deleteCharAt(current);
                sb.deleteCharAt(next);
            } else if (sb.charAt(current) == 'B' && sb.charAt(next) == 'A') {
                sb.deleteCharAt(current);
                sb.deleteCharAt(next);
            } else if (sb.charAt(current) == 'C' && sb.charAt(next) == 'D') {
                sb.deleteCharAt(current);
                sb.deleteCharAt(next);
            } else if (sb.charAt(current) == 'D' && sb.charAt(next) == 'C') {
                sb.deleteCharAt(current);
                sb.deleteCharAt(next);
            }
            current++;
            next++;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        solution("CBACD");
        solution("CBACDD");

    }
}

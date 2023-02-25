public class Z3 {
    public static String solution(int AA, int AB, int BB) {
        // Implement your solution here
        StringBuilder sb = new StringBuilder();
        // Base case
        if(AA == 0 && BB == 0) {
            while (AB > 0) {
                sb.append("AB");
                AB--;
            }
            return sb.toString();
        }

        if(AA ==0 && AB == 0) {
            return "BB";
        }

        if(BB ==0 && AB == 0) {
            return "AA";
        }

        while(countIfTwoNoExist(AA, AB, BB)) {
            if(sb.length() == 0) {
                if(AA > 0) {
                    sb.append("AA");
                    AA--;
                } else if ( AB > 0) {
                    sb.append("AB");
                    AB--;
                } else {
                    sb.append("BB");
                    BB--;
                }

            }

            if(sb.substring(sb.length()-2).equals("AA")) {
                if(BB > 0) {
                    sb.append("BB");
                    BB--;
                } else {
                    continue;
                }
            }

            if(sb.substring(sb.length()-2).equals("BB")) {
                if(AA > 0) {
                    sb.append("AA");
                    AA--;
                } else if(AB > 0) {
                    sb.append("AB");
                    AB--;
                } else {
                    continue;
                }
            }

            if(sb.substring(sb.length()-2).equals("AB")) {
                if(AA > 0) {
                    sb.append("AA");
                    AA--;
                } else if(AB > 0) {
                    sb.append("AB");
                    AB--;
                } else {
                    continue;
                }
            }
        }
        return sb.toString();
    }

    private static boolean countIfTwoNoExist(int aa, int ab, int bb) {
        if(aa > 0 && ab > 0) {
            return true;
        } else if(ab > 0 && bb > 0) {
            return true;
        } else return aa > 0 && bb > 0;
    }

    public static void main(String[] args) {
        System.out.println(solution(5, 1, 1));
    }

}

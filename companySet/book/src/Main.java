import java.util.*;

public class Main {

    public static List<String> funWithAnagaram(List<String> text) {
        if(text.size() == 0) {
            return Collections.EMPTY_LIST;
        }

        Set<String> sortedStringSet = new HashSet<>();
        for(String str: text) {
            Arrays.sort(str.toCharArray());
            if(sortedStringSet.contains(str)) {
                continue;
            } else {
                sortedStringSet.add(str);
            }
        }
    }
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}
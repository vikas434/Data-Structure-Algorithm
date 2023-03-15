import java.util.HashMap;
import java.util.Map;

public class CheckVowel {
    public static int checkVowel(String st){
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        int result = 0;
        int start = 0;
        for(int i = 0; i < st.length(); i++){
            if(!isVowel(st.charAt(i))){
                while(map.containsKey(st.charAt(start)) && map.get(st.charAt(start)) > 1){


                    map.put(st.charAt(start), map.get(st.charAt(start)) -1);
                    start++;
                    result++;
                }
                map = new HashMap<>();
                start = i+1;

            }else{
                map.put(st.charAt(i), map.getOrDefault(st.charAt(i), 0)+1);
            }
            if(map.size() == 5){
                result++;
            }
        }
        return result;
    }

    private static boolean isVowel(Character c){
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
    }

}

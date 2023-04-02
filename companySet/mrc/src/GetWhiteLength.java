import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GetWhiteLength {
    public static int getWhiteLength(int n, int m, List<List<Integer>> lists){
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(List<Integer> list: lists){
            int color = list.get(0);
            int first = list.get(1);
            int last = list.get(2);
            for(int i = first; i <= last; i++){
                if(map.containsKey(list.get(i))){
                    map.get(list.get(i)).add(color);
                }
            }
        }
        int result = 0;
        for(int key : map.keySet()){
            if(map.get(key).size() == 3 && key <= n)
                result++;
        }
        return result;
    }
}

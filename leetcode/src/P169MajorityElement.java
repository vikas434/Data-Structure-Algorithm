import java.util.HashMap;
import java.util.Map;

public class P169MajorityElement {
    public int majorityElement(int[] nums) {
        int majorElement = nums[0];
        int maxCountSoFar = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums) {
            if(map.containsKey(num)) {
                var count = map.get(num);
                count++;
                if(count > maxCountSoFar) {
                    maxCountSoFar = count;
                    majorElement = num;
                }
                map.put(num, count);
            } else{
                map.put(num, 1);
            }
        }
        return majorElement;
    }
}

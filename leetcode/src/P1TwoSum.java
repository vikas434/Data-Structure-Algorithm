import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 *
 * Example 1:
 *
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * Example 2:
 *
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * Example 3:
 *
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 */
public class P1TwoSum {
    public int[] twoSum(int[] nums, int target) {
        if(nums.length == 0) {
            return null;
        }

        int[] sumArray = new int[2];
        Map<Integer, Integer> sumMap = new HashMap<>();

        for(int i = 0; i<nums.length; i++) {
            int diffFromTarget = target - nums[i];
            if(sumMap.containsKey(diffFromTarget)) {
                sumArray[0] = sumMap.get(diffFromTarget);
                sumArray[1] = i;
                return sumArray;
            }
            sumMap.put(nums[i], i);
        }
        return sumArray;
    }
}

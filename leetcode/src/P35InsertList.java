/**
 * Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * <p>
 * You must write an algorithm with O(log n) runtime complexity.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,3,5,6], target = 5
 * Output: 2
 * Example 2:
 * <p>
 * Input: nums = [1,3,5,6], target = 2
 * Output: 1
 * Example 3:
 * <p>
 * Input: nums = [1,3,5,6], target = 7
 * Output: 4
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums contains distinct values sorted in ascending order.
 * -104 <= target <= 104
 */
public class P35InsertList {
    public static int searchInsert(int[] nums, int target) {
        int lengthArray = nums.length;
        int leftIndex = 0;
        int rightIndex = lengthArray - 1;
        int midIndex = (leftIndex + rightIndex) / 2;

        if (target > nums[rightIndex]) {
            return lengthArray;
        } else if (target < nums[leftIndex]) {
            return 0;
        } else {
            // binary search
            while (leftIndex <= rightIndex) {
                if (target == nums[midIndex]) {
                    return midIndex;
                } else if (target > nums[midIndex]) { // never forget that its an index.
                    leftIndex = midIndex+1;
                } else {
                    rightIndex = midIndex-1;
                }
                midIndex = (leftIndex + rightIndex) / 2;
            }
            return leftIndex; // Rememeber this is another catch. As we need to find left index.
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        var pos = searchInsert(nums, 2);
        System.out.println(pos);
    }
}

public class P136SingleNumber {
    public int singleNumber(int[] nums) {
        int sum = nums[0];
        if(nums.length == 1) {
            return sum;
        }

        for(int i = 1; i<nums.length; i++) {
            sum = nums[i]^sum;
        }

        return sum;


    }
}

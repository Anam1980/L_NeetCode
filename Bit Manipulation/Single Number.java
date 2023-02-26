//LEETCODE 136

/*Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

You must implement a solution with a linear runtime complexity and use only constant extra space.*/


class Solution {
    public int singleNumber(int[] nums) {
        //n^n=0---even gives 0
        //n^n^n=n--odd gives n

        int remain=0;
        for(int i=0; i<nums.length; i++){
            //twice ele gives 0 and remaining one return
            remain=remain^nums[i];
        }

        return remain;
    }
}

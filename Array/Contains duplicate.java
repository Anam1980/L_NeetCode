//LEETCODE 217

class Solution {
    public boolean containsDuplicate(int[] nums) {
        //create hashmap to store freq as a value
        Map<Integer, Integer>hm=new HashMap<>();

        for(int i=0; i<nums.length; i++){
            //if it repeats
            if(hm.containsKey(nums[i])){
                return true;
            }

            //else add with freq 1
            hm.put(nums[i], 1);
        }

        return false;
    }
}

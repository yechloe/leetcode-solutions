/*
Return indices of two numbers such that they add up to target 
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
*/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        int[] result = new int[2];
        for (int i=0; i<len; i++) {
            for (int j=i+1; j<len; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;
    }

    /*better performance O(n2) -> O(n) */
    public int[] twoSumOptimised(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> targetMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int rest = target - nums[i];
            if (targetMap.containsKey(rest)) {
                result[1] = i;
                result[0] = targetMap.get(rest);
                break;
            } else {
                targetMap.put(nums[i], i);
            }
        }
        return result;
    }
}


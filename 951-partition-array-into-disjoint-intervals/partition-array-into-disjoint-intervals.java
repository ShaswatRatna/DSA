class Solution {
    public int partitionDisjoint(int[] nums) {
        int n = nums.length;
        int maxLeft = nums[0];
        int maxSoFar = nums[0];
        int count = 0;

        for(int i=1; i<n; i++){
            maxSoFar = Math.max(maxSoFar, nums[i]);
            if(nums[i] < maxLeft){
                count = i;
                maxLeft = maxSoFar;
            }
        }
        return count+1;
    }
}
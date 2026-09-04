class Solution {
    public int minMaxGame(int[] nums) {
        int n=nums.length;
        int i = 0;
        int j = 1;
        int[] newNums = new int[n/2];
        int index=0;
        while(j<n){
            if(index%2==0){
                newNums[index] = Math.min(nums[i],nums[j]);
            }
            else{
            newNums[index] = Math.max( nums[i],nums[j]);
        }
        index++;
        i=i+2;
        j=j+2;
    }
    return n==1 ? nums[0] : minMaxGame(newNums);
  }
}
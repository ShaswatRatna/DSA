import java.util.*;
class Solution
{
    public void rotate(int[]nums, int K)
    {
        int n =nums.length;
        K = K % n ;
        reverse(nums,0,n-1);
        reverse(nums,0,K-1);
        reverse(nums,K,n-1);
    }
    private void reverse(int[]nums,int start,int end)
    {
        while(start<end)
        {
            int temp=nums[start];
            nums [start]=nums[end];
            nums [end]=temp;
            start++;
            end--;
        }
    }
}
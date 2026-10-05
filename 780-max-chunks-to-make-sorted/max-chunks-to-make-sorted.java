class Solution {
    public int maxChunksToSorted(int[] arr) {
        int r = 0 ,  sum =0 , chunks= 0;
        for ( int i = 0 ; i <arr.length;i++){
            r+=arr[i];
           sum +=i;
            if(r==sum){
                chunks++;
            }
        }
        return chunks;
    }
}
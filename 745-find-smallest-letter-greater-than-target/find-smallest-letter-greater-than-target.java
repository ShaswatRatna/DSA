class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int low=0,high=letters.length-1;
        char found=letters[0];
        while(low<=high){
            int mid=low+(high-low)/2;
            if(letters[mid]>target){
                found=letters[mid];
                high=mid-1;
            }else low=mid+1;

        }return found;
    }
}
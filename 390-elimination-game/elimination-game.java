class Solution {
    public int lastRemaining(int n) {
       int h = 1, s = 1;
       for(boolean l = true ; n>1 ; l = !l , n/=2, s*=2)
       if( l || n%2 == 1) h+=s;
       return h; 
    }
}



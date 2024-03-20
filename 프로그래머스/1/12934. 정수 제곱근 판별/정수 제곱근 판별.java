class Solution {
    public long solution(long n) {
        double x = Math.sqrt(n);
        
        if(x % 1 != 0) return -1;
        
        return (long)((x+1)*(x+1));
    }
}
class Solution {
    public int solution(int n, int k) {
        k -= n / 10;
        if(k < 0) k = 0;
        return n*12000 + k*2000;
    }
}
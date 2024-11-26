class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        int returnValue = 0;
        while(n >= a) {
            returnValue = n / a * b;
            answer += returnValue;
            
            n -= n/a*a;
            n += returnValue;
        }
        
        return answer;
    }
}
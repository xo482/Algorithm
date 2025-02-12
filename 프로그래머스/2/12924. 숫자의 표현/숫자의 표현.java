class Solution {
    public int solution(int n) {
        int answer = 0;
        int[] dp = new int[n+1];
        int p1=1, p2=1;
        
        for(int i = 1; i <= n; i++) {
            dp[i] = dp[i-1] + i;                           
        }
        
        
        while(p1 <= p2 && p2 <= n) {
            int now = dp[p2] - dp[p1] + p1;
            if(now > n) p1++;
            if(now < n) p2++;
            if(now==n) {
                answer++;
                p1++;
            }
        }
        
        return answer;
    }
}
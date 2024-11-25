class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        int d_p = n-1;
        int p_p = n-1;
        while(d_p >= 0 && deliveries[d_p] == 0) d_p--;
        while(p_p >= 0 && pickups[p_p] == 0) p_p--;
        
        long sum = 0;
        while(d_p >= 0 || p_p >= 0) {
            int distance = Math.max(d_p, p_p) + 1;
            sum += 2*distance;
            
            int cnt = 0;
            while(cnt < cap) {
                if(d_p < 0) break;
                deliveries[d_p]--;
                cnt++;
                
                while(d_p >= 0 && deliveries[d_p] == 0) d_p--;
            }
            
            cnt = 0;
            while(cnt < cap) {
                if(p_p < 0) break;
                pickups[p_p]--;
                cnt++;
                
                while(p_p >= 0 && pickups[p_p] == 0) p_p--;
            }
        }
        
        return sum;
    }
}
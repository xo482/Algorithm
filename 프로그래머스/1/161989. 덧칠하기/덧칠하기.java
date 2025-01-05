class Solution {
    public int solution(int n, int m, int[] section) {
        
        int cnt = 0;
        int[] arr = new int[n+1];
        for(int i : section) arr[i] = 1;
        
        for(int i = 1; i < n+1; i++) {
            if(arr[i] != 1) continue;
            for(int j = i; j < n+1 && j < i + m; j++) arr[j] = 0;
            cnt++;
        }
        
        return cnt;
    }
}
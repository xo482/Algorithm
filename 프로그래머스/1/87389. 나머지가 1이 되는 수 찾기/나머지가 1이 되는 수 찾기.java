class Solution {
    public int solution(int n) {
        for(int answer = 1; answer < n; answer++)
            if(n % answer == 1) 
                return answer;
        
        return -1;
    }
}
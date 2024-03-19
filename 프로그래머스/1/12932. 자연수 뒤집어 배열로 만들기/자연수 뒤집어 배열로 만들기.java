class Solution {
    public int[] solution(long n) {
        String[] str = String.valueOf(n).split("");
        int N = str.length;
        int[] answer = new int[N];
        
        for(int i = N; i > 0; i--) {
            answer[i-1] = Integer.parseInt(str[N-i]);
        }
            
        return answer;
    }
}
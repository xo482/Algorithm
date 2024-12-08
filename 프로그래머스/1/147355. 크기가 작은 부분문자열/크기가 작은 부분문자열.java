class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        long num = Long.parseLong(p);
        int size = p.length();
        
        for(int i = 0; i <= t.length()-size; i++) 
            if(num >= Long.parseLong(t.substring(i, i+size))) 
                answer++;

        return answer;
    }
}
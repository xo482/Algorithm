class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        while(true) {
            answer[0]++;
            StringBuilder sb = new StringBuilder();
            int cnt = 0;
            for(int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == '1') {
                    cnt++;
                    continue;
                }
                answer[1]++;
            }
            
            s = Integer.toBinaryString(cnt);
            
            if(s.equals("1")) break;
        }
        
        return answer;
    }
}
class Solution {
    public String solution(String rsp) {
        StringBuilder sb = new StringBuilder();
        int len = rsp.length();
        for(int i = 0; i < len; i++){
            int now = rsp.charAt(i) - '0';
            if(now == 2) sb.append(0);
            else if(now == 0) sb.append(5);
            else sb.append(2);
        }
        return sb.toString();
    }
}
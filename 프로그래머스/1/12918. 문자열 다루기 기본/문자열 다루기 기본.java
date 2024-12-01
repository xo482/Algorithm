class Solution {
    public boolean solution(String s) {
        int len = s.length();
        if(len != 4 && len != 6) return false;
        
        boolean flag = false;
        for(int i = 0; i < len; i++) {
            if(s.charAt(i) < '0' || '9' < s.charAt(i)) {
                flag = true;
                break;
            }
        }
        if(flag) return false;
        return true;
    }
}
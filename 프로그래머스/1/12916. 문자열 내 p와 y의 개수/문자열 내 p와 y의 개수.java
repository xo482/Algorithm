class Solution {
    boolean solution(String s) {
        int p = 0;
        int y = 0;

        s = s.toLowerCase();
        int len = s.length();

        for(int i = 0; i < len; i++) {
            if (s.charAt(i) == 'p') p++;
            if (s.charAt(i) == 'y') y++;
        }
        
        if (p != y) return false;
        
        return true;
    }
}
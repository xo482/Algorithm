import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        int now = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == ' ') { sb.append(c); now = 0; continue; }
            if(now % 2 == 0) c = Character.toUpperCase(c);
            if(now % 2 == 1) c = Character.toLowerCase(c);
            
            sb.append(c);
            now++;
        }
        return sb.toString();
    }
}
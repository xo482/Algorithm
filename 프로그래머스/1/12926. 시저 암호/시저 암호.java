import java.util.*;

class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            
            if('a' <= c && c <= 'z') {
                c = (char)((int)c+n);
                if(c > 'z') c = (char)((int)c - 26);
            }
            
            if('A' <= c && c <= 'Z') {
                c = (char)((int)c+n);
                if(c > 'Z') c = (char)((int)c - 26);
            }
            
            sb.append(c);
        }
        return sb.toString();
    }
}
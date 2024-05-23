import java.util.*;

class Solution {
    public String solution(String my_string) {
        StringBuilder sb = new StringBuilder();
        for(char now : my_string.toCharArray()){
            if(now > 92) sb.append((char)(now - 32));
            else sb.append((char)(now+32));
        }
        
        return sb.toString();
    }
}
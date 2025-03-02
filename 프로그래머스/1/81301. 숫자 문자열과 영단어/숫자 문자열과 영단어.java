import java.util.*;

class Solution {
    static StringBuilder sb = new StringBuilder();
    public int solution(String s) {
       
        for(int i = 0; i < s.length(); i++) {
            char num = s.charAt(i);
            if('0' <= num && num <= '9') sb.append(num);
            else if(num == 'z') { sb.append(0); i+=3; }
            else if(num == 'o') { sb.append(1); i+=2; }
            else if(num == 't') {
                if(s.charAt(i+1) == 'w') { sb.append(2); i+=2; }
                if(s.charAt(i+1) == 'h') { sb.append(3); i+=4; }
            }
            else if(num == 'f') {
                if(s.charAt(i+1) == 'o') { sb.append(4); i+=3; }
                if(s.charAt(i+1) == 'i') { sb.append(5); i+=3; }
            }
            else if(num == 's') {
                if(s.charAt(i+1) == 'i') { sb.append(6); i+=2; }
                if(s.charAt(i+1) == 'e') { sb.append(7); i+=4; }
            }
            else if(num == 'e') { sb.append(8); i+=4; }
            else if(num == 'n') { sb.append(9); i+=3; }
        }
        
        return Integer.parseInt(sb.toString());
    }
}
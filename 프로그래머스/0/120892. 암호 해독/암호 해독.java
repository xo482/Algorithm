import java.util.*;

class Solution {
    public String solution(String cipher, int code) {
        StringBuilder sb = new StringBuilder();
        for(int i = code; i <= cipher.length(); i += code) {
            sb.append(cipher.charAt(i-1));
        }
        
        return sb.toString();
    }
}
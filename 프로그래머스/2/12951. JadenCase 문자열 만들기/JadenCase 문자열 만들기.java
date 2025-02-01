import java.util.*;

class Solution {
    public String solution(String s) {
        s = s.toLowerCase();
        String[] strings = s.split(" ");
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i < strings.length; i++) {
            
            if(strings[i].length() == 0) {
                sb.append(" ");
                continue;
            }
            
            if('a' <= strings[i].charAt(0) && strings[i].charAt(0) <= 'z') {
                char[] arr = strings[i].toCharArray();
                arr[0] = (char)(arr[0] - 32);
                strings[i] = String.valueOf(arr);
            }
            
            sb.append(strings[i]).append(" ");
        }
        
        if(s.substring(s.length()-1, s.length()).equals(" ")){
    		return sb.toString();
    	}
        
        String str = sb.toString().trim();
        return str;
    }
}
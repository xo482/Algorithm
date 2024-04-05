import java.util.*;

class Solution {
    public String solution(String s) {
        List<Character> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < s.length(); i++ ) {
            list.add(s.charAt(i));
        }
        Collections.sort(list);
        Collections.reverse(list);
        
        for(Character x : list) {
            sb.append(x);
        }
        
        return sb.toString();
    }
}
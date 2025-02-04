import java.util.*;

class Solution {
    boolean solution(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') stack.add(c);
            else if(stack.isEmpty()) return false;
            else stack.removeLast();
        }
        
        return stack.isEmpty();
    }
}
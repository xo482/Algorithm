import java.util.*;
class Solution {
    public int solution(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char now = s.charAt(i);
            if (stack.isEmpty() || now != stack.getLast()) { 
                stack.addLast(now); 
                continue; 
            }
            stack.removeLast();
        }
        
        if (stack.isEmpty()) return 1;
        return 0;
    }
}
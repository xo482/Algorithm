import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        
        for(int i : arr) {
            if(stack.isEmpty()) stack.addLast(i);
            if(stack.peekLast() == i) continue;
            stack.addLast(i);
        }
        
        int len = stack.size();
        int[] answer = new int[len];
        for(int i = 0; i < len; i++) {
            answer[i] = stack.removeFirst();
        }

        return answer;
    }
}
import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        
        PriorityQueue<Integer> list = new PriorityQueue<>((o1, o2) -> Integer.compare(o1, o2));
        int[] answer = new int[score.length];
        
        for(int i = 0; i < score.length; i++) {
            list.add(score[i]);
            
            if(list.size() > k) list.poll();
            
            answer[i] = list.peek();
        }
        return answer;
    }
}
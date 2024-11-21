import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String s) {
        Map<String, Integer> map = new HashMap<>();
        s = s.substring(2, s.length()-2);
        String[] strs = s.split("},\\{");
        
        for(String str : strs) {
            String[] nums = str.split(",");
            for(String num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        
        int len = map.keySet().size();
        int[] answer = new int[len];
        for(String num : map.keySet()) {
            answer[len - map.get(num)] = Integer.parseInt(num);
        }
        
        
        
        return answer;
    }
    
}
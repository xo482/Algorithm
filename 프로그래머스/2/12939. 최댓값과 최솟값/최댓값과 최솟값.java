import java.util.*;

class Solution {
    public String solution(String str) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        String[] arr = str.split(" ");
        for(String s : arr) {
            int now = Integer.parseInt(s);
            min = Math.min(min, now);
            max = Math.max(max, now);
        }
        
        return min + " " + max;
    }
}
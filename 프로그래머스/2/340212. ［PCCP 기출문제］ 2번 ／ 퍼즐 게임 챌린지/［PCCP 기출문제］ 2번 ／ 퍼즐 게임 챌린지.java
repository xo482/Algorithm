import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int start = 1;
        int end = 100000;
        while(start <= end) {
            int mid = (start+end)/2;
            
            boolean check = checkTime(diffs, times, limit, mid);
            
            if(check) end = mid-1;
            else start = mid + 1;
        }
        
        return start;
    }
    
    static boolean checkTime(int[] diffs, int[] times, long limit, int level) {
        long sum = 0;
        int prevIdx = 0;
        boolean flag = true;
        
        for(int i = 0; i < diffs.length; i++) {
            
            if(diffs[i] - level > 0) {
                int diff = diffs[i] - level;
                sum += (long)diff * (times[prevIdx] + times[i]) + times[i];
            } else {
                sum += times[i];
            }
            
            prevIdx = i;
            
            if(sum > limit) {
                flag = false;
                break;
            }
        }
        
        if(flag) return true;
        return false;
    }
}
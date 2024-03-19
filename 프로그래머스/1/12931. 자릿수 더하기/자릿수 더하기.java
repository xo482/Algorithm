import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        
        String str = String.valueOf(n);
        String[] list = str.split("");
        
        for(String s : list) {
            answer += Integer.parseInt(s);
        }
        
        return answer;
    }
}
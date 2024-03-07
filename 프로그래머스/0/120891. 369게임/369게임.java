import java.util.*;
import java.io.*;

class Solution {
    public int solution(int order) {
        int answer = 0;
        
        String[] list = String.valueOf(order).split("");
        
        for(String N : list){
            if(N.equals("3") || N.equals("6") || N.equals("9")) answer++;
        }
        
        return answer;
    }
}
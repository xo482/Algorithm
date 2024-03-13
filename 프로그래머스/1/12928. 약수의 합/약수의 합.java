import java.util.*;

class Solution {
    public int solution(int n) {
        List<Integer> list = new ArrayList<>();
        int sum =0;
        
        for(int i=1; i<=n; i++){
            if(n%i == 0) list.add(i);
        }
        
        for(Integer x : list) sum += x;
        
        return sum;
    }
}
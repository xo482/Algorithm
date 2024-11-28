import java.util.*;

class Solution {
    public List<Integer> solution(String[] name, int[] yearning, String[][] photo) {
        
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < name.length; i++) 
            map.put(name[i], yearning[i]);
        
        for(String[] pho : photo) {
            int sum = 0;
            
            for(String p : pho) 
                if(map.containsKey(p)) 
                    sum += map.get(p);
                
            answer.add(sum);
        }
        
        return answer;
    }
}
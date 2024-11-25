import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        
        Map<String, Integer> map = new HashMap<>();
        List<int[]> list = new ArrayList<>();
        int[] now = new int[3];
        
        String[] str = today.split("\\.");
        for(int i = 0; i < 3; i++) now[i] = Integer.parseInt(str[i]);
        
        for(String s : terms) {
            str = s.split(" ");
            map.put(str[0], Integer.parseInt(str[1]));
        }
        
        for(String s : privacies) {
            str = s.split(" ");
            String[] day = str[0].split("\\.");
            int[] dday = new int[3];
            for(int i = 0; i < 3; i++) dday[i] = Integer.parseInt(day[i]);
            
            int add = map.get(str[1]);
            
            dday[1] += add;
            while(dday[1] > 12) {
                dday[1] -= 12;
                dday[0]++;
            }
            
            list.add(dday);
        }
        
        
        List<Integer> answerList = new ArrayList<>();
        for(int i = 0; i < list.size(); i++) {
            int[] dday = list.get(i);
            if(now[0] < dday[0]) continue;
            if(now[0] == dday[0]) {
                if(now[1] < dday[1]) continue;
                if(now[1] == dday[1]) {
                    if(now[2] < dday[2]) continue;
                }
            }
            answerList.add(i+1);
        }
        
        int[] answer = new int[answerList.size()];
        for(int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
}
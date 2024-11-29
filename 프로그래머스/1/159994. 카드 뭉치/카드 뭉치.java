class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int p1=0;
        int p2=0;
        
        for(int i = 0; i < goal.length; i++) {
            boolean flag = true;
            
            if(p1 != cards1.length && goal[i].equals(cards1[p1])) {
                flag = false;
                p1++;
            }
            
            if(p2 != cards2.length && goal[i].equals(cards2[p2])) {
                flag = false;
                p2++;
            }
            
            if(flag) return "No";
        }
        return "Yes";
    }
}
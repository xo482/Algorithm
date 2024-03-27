class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        
        int x = (total - ((num-1)*num / 2)) / num;
        
        for(int i = 0; i < num; i++){
            answer[i] = x+i;
        }
        
        return answer;
    }
}
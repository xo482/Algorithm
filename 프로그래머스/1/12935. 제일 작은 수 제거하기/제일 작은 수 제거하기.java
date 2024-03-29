class Solution {
    public int[] solution(int[] arr) {
        
        if (arr.length == 1) return new int[]{-1};
        
        int[] answer = new int[arr.length-1];
        int min = arr[0];
        int i = 0;
        
        for(int x : arr) {
            if (min > x) min = x;
        }
        
        for (int x : arr) {
            if (x ==min) continue;
            answer[i++] = x;
        }
        
        return answer;
    }
}
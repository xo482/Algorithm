class Solution {
    public int[] solution(int n) {
        int[] list = new int[(n%2==0)?n/2:n/2+1];
        for(int i = 0; i < list.length; i++) {
            list[i] = i*2+1;
        }
        
        return list;
    }
}
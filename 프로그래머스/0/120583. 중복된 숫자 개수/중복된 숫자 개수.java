class Solution {
    public int solution(int[] array, int n) {
        int[] arr = new int[1001];
        
        for(int i : array) {
            arr[i]++;
        }
        
        return arr[n];
    }
}
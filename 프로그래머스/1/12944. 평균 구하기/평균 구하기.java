
class Solution {
    public double solution(int[] arr) {
        int size = arr.length;
        int sum = 0;
        for(int i=0; i < size; i++) {
            sum += arr[i];
        }
        
        return (double) sum / size;
    }
}
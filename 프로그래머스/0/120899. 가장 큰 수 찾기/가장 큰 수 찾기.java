class Solution {
    public int[] solution(int[] array) {
        int max = 0;
        for(int i=0; i < array.length; i++){
            max = (array[max] > array[i])?max:i;
        }
        
        return new int[]{array[max], max};
    }
}
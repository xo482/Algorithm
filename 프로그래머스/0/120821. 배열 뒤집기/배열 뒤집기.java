class Solution {
    public int[] solution(int[] num_list) {
        int len = num_list.length;
        int[] result = new int[len];
        
        for(int i = 0; i < len; i++) {
            result[i] = num_list[len-1-i];
        }
        return result;
    }
}
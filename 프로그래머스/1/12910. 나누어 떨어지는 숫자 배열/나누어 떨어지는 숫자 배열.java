import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] res = Arrays.stream(arr)
                        .filter(i -> i % divisor == 0)
                        .sorted()
                        .toArray();
        
        if (res.length == 0) return new int[]{-1};
        return res;
    }
}
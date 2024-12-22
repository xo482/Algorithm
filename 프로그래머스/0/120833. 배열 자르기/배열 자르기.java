import java.util.*;

class Solution {
    public List<Integer> solution(int[] numbers, int start, int end) {
        List<Integer> list = new ArrayList<>();
        for(int i = start; i <= end; i++) {
            list.add(numbers[i]);
        }
        return list;
    }
}
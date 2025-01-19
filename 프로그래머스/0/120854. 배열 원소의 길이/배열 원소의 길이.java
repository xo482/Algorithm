import java.util.*;

class Solution {
    public List<Integer> solution(String[] strlist) {
        List<Integer> list = new ArrayList<>();
        for(String s : strlist) list.add(s.length());
        return list;
    }
}
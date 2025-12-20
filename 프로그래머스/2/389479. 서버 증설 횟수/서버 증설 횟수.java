import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        ArrayDeque<Integer> q = new ArrayDeque<>();

        for (int time = 0; time < 24; time++) {

            while (!q.isEmpty() && q.peekFirst() <= time) {
                q.removeFirst();
            }

            int need = players[time] / m;
            if (need > q.size()) {
                int len = need - q.size();
                for (int j = 0; j < len; j++) {
                    q.add(time + k);
                    answer++;
                }
            }
        }

        return answer;
    }
}
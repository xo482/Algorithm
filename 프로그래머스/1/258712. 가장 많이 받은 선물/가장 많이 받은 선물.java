import java.util.*;
import java.io.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        Map<String, Integer> gift_power = new HashMap<>();
        Map<String, Integer> gift_history = new HashMap<>();

        for (String gift : gifts) {
            gift_history.put(gift, gift_history.getOrDefault(gift, 0) + 1);
            StringTokenizer st = new StringTokenizer(gift);
            
            String name = st.nextToken();
            gift_power.put(name, gift_power.getOrDefault(name, 0) + 1);

            name = st.nextToken();
            gift_power.put(name, gift_power.getOrDefault(name, 0) - 1);
        }

        int len = friends.length;
        int[] arr = new int[len];

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                String i_to_j = friends[i] + " " + friends[j];
                String j_to_i = friends[j] + " " + friends[i];

                int a = gift_history.getOrDefault(i_to_j, 0);
                int b = gift_history.getOrDefault(j_to_i, 0);

                if (a == b) {
                    int i_power = gift_power.getOrDefault(friends[i], 0);
                    int j_power = gift_power.getOrDefault(friends[j], 0);

                    if (i_power == j_power) continue;
                    if (i_power > j_power) arr[i]++;
                    else arr[j]++;

                    continue;
                }

                if (a > b) arr[i]++;
                else arr[j]++;
            }
        }

        int max = 0;
        for (int i = 0; i < len; i++) max = Math.max(max, arr[i]);
        return max;
    }
}
import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int T, K;
    static char[] W;
    static Map<Character, List<Integer>> map;

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {

            int max = -1;
            int min = 10000;
            map = new HashMap<>();

            W = br.readLine().toCharArray();
            K = Integer.parseInt(br.readLine());

            for (int i = 0; i < W.length; i++) {
                char key = W[i];
                if (!map.containsKey(key))
                    map.put(key, new ArrayList<>());

                map.get(key).add(i);
            }

            for (char key : map.keySet()) {
                List<Integer> list = map.get(key);
                if (list.size() < K) continue;

                for (int i = 0; i <= list.size() - K; i++) {
                    int len = list.get(i + K - 1) - list.get(i) + 1;
                    max = Math.max(max, len);
                    min = Math.min(min, len);
                }
            }

            if (max == -1) sb.append("-1\n");
            else sb.append(min).append(" ").append(max).append("\n");
        }
        System.out.println(sb);
    }
}
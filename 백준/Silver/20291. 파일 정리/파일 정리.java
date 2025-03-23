import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Map<String, Integer> map = new HashMap<>();
    static int N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            String key = br.readLine().split("\\.")[1];
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        List<String> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);
        for(String key : keys) sb.append(key).append(" ").append(map.get(key)).append("\n");
        System.out.println(sb);
    }
}

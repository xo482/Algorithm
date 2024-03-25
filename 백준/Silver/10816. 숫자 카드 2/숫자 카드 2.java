import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> map = new HashMap<>();
        int N = Integer.parseInt(br.readLine());

        String[] str = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            String key = str[i];
            if (map.containsKey(key)) {
                map.put(key, map.get(key)+1);
            } else {
                map.put(key, 1);
            }
        }

        int M = Integer.parseInt(br.readLine());
        str = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            if (!map.containsKey(str[i])) sb.append("0 ");
            else sb.append(map.get(str[i])).append(" ");
        }


        System.out.print(sb);
    }
}
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        Map<Integer, String> map = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            map.put(i, str);
            map2.put(str,i);
        }

        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            if (48 < str.charAt(0) && str.charAt(0) < 58) {
                sb.append(map.get(Integer.parseInt(str))).append("\n");
            } else {
                sb.append(map2.get(str)).append("\n");
            }
        }

        System.out.print(sb);
    }
}
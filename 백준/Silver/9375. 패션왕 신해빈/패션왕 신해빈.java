import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int T;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            Map<String, Integer> map = new HashMap<>();
            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                st.nextToken();
                String str = st.nextToken();
                if (map.containsKey(str)) map.replace(str, map.get(str) + 1);
                else map.put(str, 1);
            }

            int cnt = 1;
            for (int i : map.values()) {
                cnt *= (i+1);
            }
            sb.append(cnt - 1).append("\n");
        }

        System.out.print(sb);
    }
}
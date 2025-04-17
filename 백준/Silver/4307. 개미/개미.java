import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String s = br.readLine();
            if (s == null || s.isEmpty()) break;
            st = new StringTokenizer(s);
            int len = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            int min = 0;
            int max = 0;

            while (n-- > 0) {
                int pos = Integer.parseInt(br.readLine());
                min = Math.max(min, Math.min(pos, len - pos));
                max = Math.max(max, Math.max(pos, len - pos));
            }
            sb.append(min).append(" ").append(max).append("\n");
        }
        System.out.print(sb);
    }
}
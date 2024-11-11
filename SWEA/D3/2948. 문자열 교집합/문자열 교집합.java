import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int T;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            Set<String> set = new HashSet<>();
            st = new StringTokenizer(br.readLine());
            int save = Integer.parseInt(st.nextToken());
            int check = Integer.parseInt(st.nextToken());
            int cnt = 0;

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < save; i++) set.add(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < check; i++)
                if (set.contains(st.nextToken()))
                    cnt++;

            sb.append("#").append(t + 1).append(" ").append(cnt).append("\n");
        }
        System.out.print(sb.toString());
    }
}
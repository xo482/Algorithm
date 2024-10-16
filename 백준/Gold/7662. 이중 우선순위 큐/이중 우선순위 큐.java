import com.sun.source.tree.Tree;

import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int T;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int k = Integer.parseInt(br.readLine());
            TreeMap<Long, Integer> map = new TreeMap<>();

            while (k-- > 0) {
                st = new StringTokenizer(br.readLine());

                if (st.nextToken().charAt(0) == 'I') {
                    Long key = Long.parseLong(st.nextToken());
                    map.put(key, map.getOrDefault(key,0)+1);
                }
                else {
                    if (map.isEmpty()) continue;

                    Long key;

                    if (st.nextToken().charAt(0) == '1') key = map.lastKey();
                    else key = map.firstKey();

                    if (map.get(key) == 1) map.remove(key);
                    else map.put(key, map.get(key) - 1);
                }
            }

            if (map.isEmpty()) sb.append("EMPTY");
            else sb.append(map.lastKey()).append(" ").append(map.firstKey());
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
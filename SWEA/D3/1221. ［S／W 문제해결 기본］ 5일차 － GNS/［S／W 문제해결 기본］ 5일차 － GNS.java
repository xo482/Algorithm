import java.io.*;
import java.util.*;

public class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Map<String, Integer> map = new HashMap<>();
    static Map<Integer, String> map2 = new HashMap<>();
    static int N, T;

    public static void main(String[] args) throws IOException {

        map.put("ZRO", 0); map.put("ONE", 1); map.put("TWO", 2); map.put("THR", 3); map.put("FOR", 4);
        map.put("FIV", 5); map.put("SIX", 6); map.put("SVN", 7); map.put("EGT", 8); map.put("NIN", 9);

        map2.put(0, "ZRO"); map2.put(1, "ONE"); map2.put(2, "TWO"); map2.put(3, "THR"); map2.put(4, "FOR");
        map2.put(5, "FIV"); map2.put(6, "SIX"); map2.put(7, "SVN"); map2.put(8, "EGT"); map2.put(9, "NIN");


        T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            List<Integer> list = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            st = new StringTokenizer(br.readLine());
            sb.append(st.nextToken()).append("\n");
            N = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) list.add(map.get(st.nextToken()));

            Collections.sort(list);
            for(int i : list) sb.append(map2.get(i)).append(" ");
            System.out.println(sb);
        }

    }

}

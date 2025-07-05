import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M;
    static Map<String, int[][]> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int day = Integer.parseInt(st.nextToken())-1;
            int upTime = upTimeCalculate(st.nextToken(), st.nextToken());
            if (!map.containsKey(name)) map.put(name, new int[M / 7][2]);

            map.get(name)[day / 7][0]++;
            map.get(name)[day / 7][1] += upTime;
        }

        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        for (String name : list) {
            int[][] now = map.get(name);
            boolean flag = false;

            for (int i = 0; i < M / 7; i++) {
                if (now[i][0] < 5 || now[i][1] < 3600) {
                    flag = true;
                    break;
                }
            }

            if (flag) continue;
            sb.append(name).append("\n");
        }

        if (sb.toString().equals("")) System.out.println(-1);
        else System.out.println(sb);
    }

    private static int upTimeCalculate(String s, String e) {
        String[] split = s.split(":");
        int st = Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
        split = e.split(":");
        int et = Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
        return et - st;
    }
}


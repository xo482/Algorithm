import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, L, ans = 0;
    static List<int[]> holes = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            holes.add(new int[]{s, e});
        }

        Collections.sort(holes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[1];
            }
        });

        while (!holes.isEmpty()) {
            int[] now = holes.remove(0);
//            System.out.print("now[0] = " + now[0]);
//            System.out.print(", now[1] = " + now[1]);
            int cnt = (now[1] - now[0]) / L;
            if ((now[1] - now[0]) % L != 0) cnt++;

//            System.out.println(", cnt = " + cnt);
            ans += cnt;

            if (holes.isEmpty()) break;

            now[0] += L * cnt;
            int[] nxt = holes.get(0);
            while (nxt[1] <= now[0]) {
                holes.remove(0);
                if (holes.isEmpty()) break;
                nxt = holes.get(0);
            }

            if (nxt[0] < now[0]) nxt[0] = now[0];
        }

        System.out.println(ans);
    }
}
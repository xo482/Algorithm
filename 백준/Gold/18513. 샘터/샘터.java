import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, K;
    static long ans = 0;
    static ArrayDeque<Site> Q = new ArrayDeque<>();
    static Set<Integer> visited = new HashSet<>();
    static int[] move = new int[]{-1, 1};

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int pos = Integer.parseInt(st.nextToken());
            Q.add(new Site(pos, 0));
            visited.add(pos);
        }

        while (K > 0) {
            Site now = Q.removeFirst();

            for (int i = 0; i < 2; i++) {
                int nxt_pos = now.pos + move[i];
                if (visited.contains(nxt_pos)) continue;

                visited.add(nxt_pos);
                ans += now.index + 1;
                K--;
                if(K == 0) break;
                Q.add(new Site(nxt_pos, now.index + 1));
            }
        }
        System.out.println(ans);
    }

    static class Site {
        int pos;
        int index;

        public Site(int pos, int index) {
            this.pos = pos;
            this.index = index;
        }
    }
}
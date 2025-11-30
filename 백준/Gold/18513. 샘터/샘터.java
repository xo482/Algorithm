import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, K;
    static long ans = 0;
    static PriorityQueue<Site> pq = new PriorityQueue<>();
    static Set<Integer> visited = new HashSet<>();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int pos = Integer.parseInt(st.nextToken());
            pq.add(new Site(pos, 1));
            visited.add(pos);
        }

        while (K > 0) {
            Site now = pq.poll();
            int left = now.pos - now.distance;
            int right = now.pos + now.distance;

            boolean flag = false;
            if (!visited.contains(left)) {
                visited.add(left);
                ans += now.distance;
                K--;
                flag = true;
            }
            if (K == 0) break;

            if (!visited.contains(right)) {
                visited.add(right);
                ans += now.distance;
                K--;
                flag = true;
            }
            
            if (flag) pq.add(new Site(now.pos, now.distance + 1));
        }

        System.out.println(ans);
    }

    static class Site implements Comparable<Site>{
        int pos;
        int distance;

        public Site(int pos, int distance) {
            this.pos = pos;
            this.distance = distance;
        }

        @Override
        public int compareTo(Site o) {
            return this.distance - o.distance;
        }
    }
}
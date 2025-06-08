import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static PriorityQueue<Node> Q = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            Q.add(new Node(x, y));
        }

        int preY = 0;
        while (!Q.isEmpty()) {
            Node now = Q.poll();
            if (preY < now.x) {
                preY = now.y;
                N -= now.y - now.x;
                continue;
            }


            if (now.y - preY > 0) N -= now.y - preY;
            preY = Math.max(preY, now.y);
        }

        System.out.println(N);
    }

    static class Node implements Comparable<Node>{
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Node o) {
//            if (this.x == o.x) return this.x - o.x;
            return this.x - o.x;
        }
    }
}

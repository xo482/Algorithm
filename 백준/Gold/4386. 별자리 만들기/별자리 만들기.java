import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int[] isParent;
    static double answer = 0;
    static List<Point> points = new ArrayList<>();
    static PriorityQueue<Edge> Q = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        isParent = new int[N];
        for (int i = 0; i < N; i++) isParent[i] = i;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            points.add(new Point(i, x, y));
        }


        for (int i = 0; i < N; i++) {
            Point point_1 = points.get(i);

            for (int j = i+1; j < N; j++) {
                Point point_2 = points.get(j);

                double weight = Math.sqrt(Math.pow(point_1.x - point_2.x, 2) + Math.pow(point_1.y - point_2.y, 2));
                Q.add(new Edge(point_1.ID, point_2.ID, weight));
            }
        }

        int cnt = 0;
        while (!Q.isEmpty()) {
            Edge edge = Q.poll();
            int p1 = find(edge.ID_1);
            int p2 = find(edge.ID_2);
            if (p1 != p2) {
                isParent[p2] = p1;
                answer += edge.w;
            }
        }

        System.out.print(answer);
    }

    static int find(int a) {
        if (isParent[a] == a) return a;
        return isParent[a] = find(isParent[a]);
    }

    static class Edge implements Comparable<Edge>{
        int ID_1, ID_2;
        double w;

        public Edge(int ID_1, int ID_2, double w) {
            this.ID_1 = ID_1;
            this.ID_2 = ID_2;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            if (this.w < o.w) return -1;
            return 1;
        }
    }

    static class Point {
        int ID;
        double x, y;

        public Point(int ID, double x, double y) {
            this.ID = ID;
            this.x = x;
            this.y = y;
        }
    }
}
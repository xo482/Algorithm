import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<double[]> list = new ArrayList<>();
    static int N;
    static double[] time;
    static PriorityQueue<Node> Q = new PriorityQueue<>(new Comparator<Node>() {
        @Override
        public int compare(Node o1, Node o2) {
            return (o1.time - o2.time < 0) ? -1 : 1;
        }
    });

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        double[] start = new double[2];
        start[0] = Double.parseDouble(st.nextToken());
        start[1] = Double.parseDouble(st.nextToken());

        st = new StringTokenizer(br.readLine());
        double[] end = new double[2];
        end[0] = Double.parseDouble(st.nextToken());
        end[1] = Double.parseDouble(st.nextToken());
        list.add(end);

        N = Integer.parseInt(br.readLine());
        time = new double[N + 1];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            double[] point = new double[2];
            point[0] = Double.parseDouble(st.nextToken());
            point[1] = Double.parseDouble(st.nextToken());
            list.add(point);
        }

        // 초기 걸어가는 시간 설정
        for (int i = 0; i < N + 1; i++) {
            time[i] = cal(start, list.get(i)) / 5.0;
            Q.add(new Node(i, time[i]));
        }

        while (!Q.isEmpty()) {
            Node now = Q.poll();
            if (time[now.idx] < now.time) continue;
            time[now.idx] = now.time;

            if (now.idx == 0) {
                System.out.println(now.time);
                return;
            }

            for (int nxt = 0; nxt < N+1; nxt++) {
                if (now.idx == nxt) continue;

                if (time[nxt] > Math.abs(cal(list.get(now.idx), list.get(nxt)) - 50.0)/5.0 + 2.0 + now.time) {
                    time[nxt] = Math.abs(cal(list.get(now.idx), list.get(nxt)) - 50.0)/5.0 + 2.0 + now.time;
                    Q.add(new Node(nxt, time[nxt]));
                }
            }
        }
    }

    static double cal(double[] p1, double[] p2) {
        return Math.sqrt((p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]));
    }

    static class Node {
        int idx;
        double time;

        public Node(int idx, double distance) {
            this.idx = idx;
            this.time = distance;
        }
    }
}
import org.w3c.dom.Node;

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M, start, end, value;
    static int[] distance;
    static List<int[]>[] list;
    static int INF = 5000_0001;
    static PriorityQueue<Node> Q = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        distance = new int[N + 1];
        Arrays.fill(distance, INF);
        list = new List[N + 1];
        for (int i = 1; i < N + 1; i++) list[i] = new ArrayList<>();

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            value = Integer.parseInt(st.nextToken());
            list[start].add(new int[]{end, value});
            list[end].add(new int[]{start, value});
        }

        dijkstra(1);
        System.out.print(distance[N]);
    }

    private static void dijkstra(int start) {
        distance[start] = 0;
        Q.add(new Node(start, distance[start]));

        while (!Q.isEmpty()) {
            Node curNode = Q.remove();

            if (distance[curNode.idx] < curNode.cost) continue;
            for (int[] next: list[curNode.idx]) {
                int nextIdx = next[0];
                int weight = next[1];

                if (distance[nextIdx] > weight + distance[curNode.idx]) {
                    distance[nextIdx] = weight + distance[curNode.idx];
                    Q.add(new Node(nextIdx, distance[nextIdx]));

                }

            }
        }
    }

    static class Node{
        int idx;
        int cost;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }
}
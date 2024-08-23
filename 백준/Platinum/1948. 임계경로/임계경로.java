import java.io.*;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int n, m, start, end, cnt = 0;
    static List<Node>[] list;
    static List<Node>[] backList;
    static int[] inDegree, weights;
    static ArrayDeque<Integer> Q = new ArrayDeque<>();
    static ArrayDeque<Integer> backQ = new ArrayDeque<>();
    static HashSet<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        inDegree = new int[n + 1];
        weights = new int[n + 1];
        list = new List[n + 1];
        for (int i = 1; i <= n; i++) list[i] = new ArrayList<>();
        backList = new List[n + 1];
        for (int i = 1; i <= n; i++) backList[i] = new ArrayList<>();

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int now = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list[now].add(new Node(next, weight));
            backList[next].add(new Node(now, weight));
            inDegree[next]++;
        }
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        Q.addLast(start);
        while (!Q.isEmpty()) {

            int now = Q.removeFirst();

            for (Node next : list[now]) {
                weights[next.number] = Math.max(weights[next.number], weights[now] + next.weight);
                inDegree[next.number]--;

                if (inDegree[next.number] == 0) Q.addLast(next.number);
            }
        }

        backQ.addLast(end);
        while (!backQ.isEmpty()) {
            int now = backQ.removeFirst();

            for (Node next : backList[now]) {
                if (weights[now] == weights[next.number] + next.weight) {
                    if(!backQ.contains(next.number)) backQ.addLast(next.number);
                    String str = now + " " + next.number;
                    if (!set.contains(str)) set.add(str);
                }
            }
        }

        sb.append(weights[end]).append("\n").append(set.size());
        System.out.print(sb);
    }

    static class Node {
        int number;
        int weight;

        public Node(int number, int weight) {
            this.number = number;
            this.weight = weight;
        }
    }
}
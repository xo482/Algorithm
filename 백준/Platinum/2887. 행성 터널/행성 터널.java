import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int[] isParent;
    static ArrayList<Node> nodeList = new ArrayList<>();
    static PriorityQueue<Edge> Q = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        isParent = new int[N];
        for (int i = 0; i < N; i++) isParent[i] = i;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            nodeList.add(new Node(i, x, y, z));
        }

        nodeList.sort((o1, o2) -> Integer.compare(o1.x, o2.x));
        for (int i = 0; i < N - 1; i++)
            Q.add(new Edge(nodeList.get(i).num, nodeList.get(i+1).num, nodeList.get(i+1).x-nodeList.get(i).x));

        nodeList.sort((o1, o2) -> Integer.compare(o1.y, o2.y));
        for (int i = 0; i < N - 1; i++)
            Q.add(new Edge(nodeList.get(i).num, nodeList.get(i+1).num, nodeList.get(i+1).y-nodeList.get(i).y));

        nodeList.sort((o1, o2) -> Integer.compare(o1.z, o2.z));
        for (int i = 0; i < N - 1; i++)
            Q.add(new Edge(nodeList.get(i).num, nodeList.get(i+1).num, nodeList.get(i+1).z-nodeList.get(i).z));


        int cnt = 0, total = 0;
        while (!Q.isEmpty()) {
            Edge now = Q.poll();
            int p1P = findParent(now.p1);
            int p2P = findParent(now.p2);

            if (p1P == p2P) continue;
            isParent[p1P] = p2P;
            total += now.cost;
            cnt++;

            if (cnt == N-1) break;
        }
        System.out.println(total);
    }

    static int findParent(int num) {
        if (num == isParent[num]) return num;
        return isParent[num] = findParent(isParent[num]);
    }

    static class Node{
        int num;
        int x;
        int y;
        int z;

        public Node(int num, int x, int y, int z) {
            this.num = num;
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    static class Edge{
        int p1;
        int p2;
        int cost;

        public Edge(int p1, int p2, int cost) {
            this.p1 = p1;
            this.p2 = p2;
            this.cost = cost;
        }
    }
}
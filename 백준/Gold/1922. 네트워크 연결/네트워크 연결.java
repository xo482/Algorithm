import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M, sum = 0;
    static PriorityQueue<Case> Q = new PriorityQueue<Case>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
    static int[] isParent;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        isParent = new int[N+1];
        for (int i = 0; i <N+1; i++) isParent[i] = i;

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            Q.add(new Case(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        while (!Q.isEmpty()) {
            Case now = Q.poll();
            int aP = findParent(now.a);
            int bP = findParent(now.b);

            if (aP == bP) continue;
            isParent[aP] = bP;
            sum += now.cost;
        }

        System.out.println(sum);
    }

    static int findParent(int node) {
        if (node == isParent[node]) return node;
        return isParent[node] = findParent(isParent[node]);
    }

    static class Case {
        int a;
        int b;
        int cost;

        public Case(int a, int b, int cost) {
            this.a = a;
            this.b = b;
            this.cost = cost;
        }
    }
}
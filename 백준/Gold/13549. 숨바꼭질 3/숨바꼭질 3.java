import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, K;
    static int INF = 100_001;
    static int[] board = new int[100_001];
    static PriorityQueue<Node> Q = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.time, o2.time));

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        Arrays.fill(board, INF);

        Q.add(new Node(N, 0));
        board[N] = 0;

        while (!Q.isEmpty()) {
            Node now = Q.poll();

            if (board[now.v] < now.time) continue;

            board[now.v] = now.time;
            if (now.v - 1 >= 0 && board[now.v - 1] > board[now.v] + 1) {
                board[now.v - 1] = board[now.v] + 1;
                Q.add(new Node(now.v - 1, board[now.v - 1]));
            }
            if (now.v + 1 < 100_001 && board[now.v + 1] > board[now.v] + 1) {
                board[now.v + 1] = board[now.v] + 1;
                Q.add(new Node(now.v + 1, board[now.v + 1]));
            }

            if (now.v * 2 < 100_001 && board[now.v * 2] > board[now.v]) {
                board[now.v * 2] = board[now.v];
                Q.add(new Node(now.v * 2, board[now.v * 2]));
            }
        }

        System.out.println(board[K]);
    }

    static class Node {
        int v;
        int time;

        public Node(int v, int time) {
            this.v = v;
            this.time = time;
        }
    }
}
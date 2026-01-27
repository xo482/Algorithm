import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, K;
    static int[][] arr;
    static boolean[][] visited;
    static ArrayDeque<Node> q = new ArrayDeque<>();
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[2][N+1];
        visited = new boolean[2][N+1];

        char[] chars = br.readLine().toCharArray();
        for (int i = 1; i <= N; i++) arr[0][i] = chars[i-1] - '0';
        chars = br.readLine().toCharArray();
        for (int i = 1; i <= N; i++) arr[1][i] = chars[i-1] - '0';


        int[] dr = new int[]{0, 0, 1};
        int[] dc = new int[]{1, -1, K};

        q.add(new Node(0, 1));
        arr[0][1] = 0;
        visited[0][1] = true;

        while (!q.isEmpty()) {
            Node now = q.removeFirst();
            if (flag) break;

            for (int i = 0; i < 3; i++) {
                int nr = (now.r + dr[i]) % 2;
                int nc = now.c + dc[i];

                if (nc > N) { flag = true; break; }
                if (arr[nr][nc] == 0) continue;
                if (visited[nr][nc]) continue;
                if (arr[now.r][now.c] + 1 >= nc) continue;

                q.add(new Node(nr, nc));
                arr[nr][nc] = arr[now.r][now.c] + 1;
                visited[nr][nc] = true;
            }
        }

        if (flag) System.out.println(1);
        else System.out.println(0);
    }

    static class Node {
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
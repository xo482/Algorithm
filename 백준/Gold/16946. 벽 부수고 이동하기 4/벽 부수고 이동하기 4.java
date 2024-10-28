import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M;
    static int[][][] board;
    static int[] dr = new int[]{-1, 1, 0, 0};
    static int[] dc = new int[]{0, 0, 1, -1};
    static ArrayDeque<int[]> startPoint = new ArrayDeque<>();
    static ArrayDeque<int[]> queue = new ArrayDeque<>();
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M][2];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                board[i][j][0] = Integer.parseInt(line[j]);
                if (board[i][j][0] == 1) startPoint.add(new int[]{i, j});
            }
        }

        // 섬의 크기를 구한다.
        int code = 1;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                if (board[i][j][0] == 0)
                    bfs(i, j, code++);

        // 시작 위치와 연결된 섬들의 합을 구한다.
        while (!startPoint.isEmpty()) {
            int[] point = startPoint.poll();
            int r = point[0];
            int c = point[1];
            int sum = 0;
            ArrayList<Integer> codeList = new ArrayList<>();

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
                if (board[nr][nc][0] >= 0) continue;
                if (codeList.contains(board[nr][nc][1])) continue;

                codeList.add(board[nr][nc][1]);
                sum -= board[nr][nc][0];
            }
            board[r][c][0] = (sum+1) % 10;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j][0] < 0) sb.append("0");
                else sb.append(board[i][j][0]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void bfs(int startR, int startC, int code) {
        ArrayDeque<int[]> list = new ArrayDeque<>(); // 갯수 가지고 있을거임

        queue.add(new int[]{startR, startC});
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int r = point[0];
            int c = point[1];

            if (visited[r][c]) continue;

            visited[r][c] = true;
            list.add(new int[]{r, c});

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
                if (board[nr][nc][0] != 0) continue;
                if (!visited[nr][nc]) queue.add(new int[]{nr, nc});
            }
        }

        int num = (-1) * list.size();
        for (int[] ints : list) {
            int r = ints[0];
            int c = ints[1];
            board[r][c][0] = num;
            board[r][c][1] = code;
        }
    }
}
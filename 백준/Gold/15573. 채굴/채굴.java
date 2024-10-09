import java.io.*;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M, K;
    static int max = 1, min = 1_000_000;
    static int[][] board;
    static boolean[][] visited;
    static int[] dr = new int[]{1, -1, 0, 0};
    static int[] dc = new int[]{0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        board = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, board[i][j]);
                min = Math.min(min, board[i][j]);
            }
        }

        // 채굴기의 강도를 이분탐색
        int start = min;
        int end = max;
        int mid = -1;

//        System.out.println("start = " + start);
//        System.out.println("end = " + end);

        while (start <= end) {
            mid = (start + end) / 2;
            int sum = bfs(mid);
//            System.out.print("채굴기의 강도 = " + mid);
//            System.out.println(", 캔 광물 수 = " + sum);

            if (start == end) {
                if (sum >= K) {
                    break;
                } else {
                    start += 1;
                    break;
                }
            }

            // 원하는 광물의 수보다 적을 경우 채굴기의 성능을 높인다.
            if (sum < K) {
                start = mid+1;
            } else {
                end = mid;
            }
        }

        System.out.println(start);
    }

    private static int bfs(int d) {
        visited = new boolean[N][M];
        ArrayDeque<int[]> Q = new ArrayDeque<>();

        for (int j = 0; j < M; j++) {
            if (board[0][j] <= d) {
                Q.addLast(new int[]{0, j});
            }
        }
        for (int i = 1; i < N; i++) {
            if (board[i][0] <= d) {
                Q.addLast(new int[]{i, 0});
            }
            if (board[i][M-1] <= d) {
                Q.addLast(new int[]{i, M-1});
            }
        }

        int cnt = 0;
        while (!Q.isEmpty()) {
            int[] cur = Q.removeFirst();
            int r = cur[0];
            int c = cur[1];

            if (visited[r][c]) continue;

            visited[r][c] = true;
            cnt++;

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc] && board[nr][nc] <= d) {
                    Q.addLast(new int[]{nr, nc});
                }
            }
        }

        return cnt;
    }
}

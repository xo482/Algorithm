import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static char[][] board = new char[12][6];
    static boolean[][] visited;
    static int ans = 0;
    static int[] dr = new int[]{1, -1, 0, 0};
    static int[] dc = new int[]{0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 12; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < 6; j++) board[i] = chars;
        }


        while (true) {
            boolean boom = false;
            visited = new boolean[12][6];
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (board[i][j] == '.') continue;
                    if (visited[i][j]) continue;

                    List<int[]> list = bfs(i,j);
                    if (list.size() < 4)continue;

                    boom = true;
                    for (int[] points : list) board[points[0]][points[1]] = '.';
                    break;
                }
            }
            if (!boom) break; // 터진게 없었다는 소리임 그러면 끝임
//            printt();
            gravity();
//            printt();
            ans++;
        }

        System.out.println(ans);
    }

    private static void printt() {
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void gravity() {
        for (int i = 10; i >= 0; i--) {
            for (int j = 0; j < 6; j++) {
                if (board[i][j] != '.') {
                    int r = i+1;

                    while (true) {
                        if (r == 12) break;
                        if (board[r][j] != '.') break;
                        r += 1;
                    }

                    if (board[r-1][j] == '.') {
                        board[r-1][j] = board[i][j];
                        board[i][j] = '.';
                    }
                }
            }
        }
    }

    private static List<int[]> bfs(int i, int j) {
        char x = board[i][j];
        List<int[]> list = new ArrayList<>();
        ArrayDeque<int[]> Q = new ArrayDeque<>();

        Q.add(new int[]{i, j});
        list.add(new int[]{i, j});
        visited[i][j] = true;

        while (!Q.isEmpty()) {
            int[] now = Q.removeFirst();

            for (int k = 0; k < 4; k++) {
                int nr = now[0] + dr[k];
                int nc = now[1] + dc[k];

                if (nr >= 12 || nr < 0 || nc >= 6 || nc < 0) continue;
                if (board[nr][nc] != x) continue;
                if (visited[nr][nc]) continue;

                Q.add(new int[]{nr, nc});
                list.add(new int[]{nr, nc});
                visited[nr][nc] = true;
            }
        }

        return list;
    }

}
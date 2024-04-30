import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] dr = new int[]{1, -1, 0, 0};
        int[] dc = new int[]{0, 0, -1, 1};
        int[][] adj = new int[N][N];
        boolean[][] visited = new boolean[N][N];
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) adj[i][j] = line[j] - '0';
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && adj[i][j] == 1) {

                    int cnt = 1;
                    ArrayDeque<int[]> Q = new ArrayDeque<>();
                    Q.addLast(new int[]{i,j});
                    visited[i][j] = true;

                    while (!Q.isEmpty()) {
                        int[] ints = Q.removeFirst();
                        int r = ints[0];
                        int c = ints[1];

                        for (int k = 0; k < 4; k++) {
                            int nr = r + dr[k];
                            int nc = c + dc[k];
                            if (nr >= 0 && nc >= 0 && nr < N && nc < N &&
                                    !visited[nr][nc] && adj[nr][nc] == 1) {

                                Q.addLast(new int[]{nr, nc});
                                visited[nr][nc] = true;
                                cnt++;
                            }
                        }
                    }
                    list.add(cnt);
                }
            }
        }
        sb.append(list.size()).append("\n");
        Collections.sort(list);
        for (Integer i : list) {
            sb.append(i).append("\n");
        }
        System.out.print(sb);
    }
}
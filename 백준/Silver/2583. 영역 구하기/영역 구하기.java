import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int[] dr = new int[]{1, -1, 0, 0};
        int[] dc = new int[]{0, 0, -1, 1};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] adj = new int[N][M];
        ArrayList<Integer> list = new ArrayList<>();
        int cnt = 0;

        while (K-- > 0) {
            st = new StringTokenizer(br.readLine());
            int c1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            for (int i = r1 ; i < r2; i++) {
                for (int j = c1; j < c2; j++) {
                    adj[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (adj[i][j] == 0) {
                    adj[i][j] = 1;
                    cnt++;
                    int area = 0;
                    ArrayDeque<int[]> Q = new ArrayDeque<>();
                    Q.addLast(new int[]{i, j});

                    while (!Q.isEmpty()) {
                        int[] ints = Q.removeFirst();
                        int r = ints[0];
                        int c = ints[1];
                        area++;

                        for (int k = 0; k < 4; k++) {
                            int nr = r + dr[k];
                            int nc = c + dc[k];
                            if (nr >= 0 && nr < N && nc >= 0 && nc < M && adj[nr][nc] == 0) {
                                adj[nr][nc] = 1;
                                Q.addLast(new int[]{nr, nc});
                            }
                        }
                    }
                    list.add(area);
                }
            }
        }

        sb.append(cnt).append("\n");
        Collections.sort(list);
        for (Integer i : list) {
            sb.append(i).append(" ");
        }

        System.out.print(sb);
    }
}
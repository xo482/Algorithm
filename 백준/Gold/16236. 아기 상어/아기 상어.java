import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, R, C;
    static int size = 2, sizeCnt = 0, total = 0;
    static int[][] adj;
    static int[] dr = new int[]{1, -1, 0, 0};
    static int[] dc = new int[]{0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        adj = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                adj[i][j] = Integer.parseInt(st.nextToken());
                if (adj[i][j] == 9) {
                    R = i;
                    C = j;
                }
            }
        }

        while (true) {
            int[] answer = bfs(R, C);
            if (answer[2] == -99) break;
            total+=answer[2];

            sizeCnt++;
            if (sizeCnt == size) {
                sizeCnt = 0;
                size++;
            }
            R = answer[0];
            C = answer[1];
        }
        System.out.println(total);
    }

    private static int[] bfs(int departR, int departC) {
        adj[departR][departC] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {

                // 만약 거리가 같다면
                if (o1[2] == o2[2]){
                    // 만약 높이가 같다면
                    if (o2[0] == o1[0]) return o1[1] - o2[1]; // 더 왼쪽에 있는걸 먹음
                    return o1[0] - o2[0]; // 더 위에 있는걸 먹음
                }
                return o1[2] - o2[2]; // 가장 가까운 순으로 정렬
            }
        });

        ArrayDeque<int[]> Q = new ArrayDeque<>();
        int[][] visited = new int[N][N];
        Q.add(new int[]{departR, departC});
        visited[departR][departC] = 1;

        while (!Q.isEmpty()) {
            int[] now = Q.removeFirst();
            int r = now[0];
            int c = now[1];

            if (adj[r][c] < size && adj[r][c] != 0) pq.add(new int[]{r, c, visited[r][c]-1});

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nr < N && nc >= 0 && nc < N && visited[nr][nc] == 0 && adj[nr][nc] <= size) {
                    visited[nr][nc] = visited[r][c] + 1;
                    Q.add(new int[]{nr, nc});
                }
            }
        }

        if (pq.isEmpty()) return new int[]{-99,-99,-99};
        return pq.poll();
    }
}
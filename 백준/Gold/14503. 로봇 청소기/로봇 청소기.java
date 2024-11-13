import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M, cnt = 0;
    static int[][] arr;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        if (d==1) d=3;
        else if (d==3) d=1;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }

        if (arr[r][c] == 1) {
            System.out.println("0");
            return;
        }

        execute(r, c, d);
    }

    static void execute(int r, int c, int d) {
        while (true) {
            // 현재 칸이 아직 청소되지 않은 경우 현재 칸을 청소한다.
            if (arr[r][c] == 0){
                arr[r][c] = 2;
                cnt++;
                continue;
            }

            // 현재 칸이 청소된 칸인 경우
            if (arr[r][c] == 2){
                // 주변 4칸 중
                boolean flag = true;
                for (int i = 1; i < 5; i++) {
                    int nr = r + dr[(d+i) %4];
                    int nc = c + dc[(d+i) %4];

                    // 청소할 수 있는 칸이 있으면 거기로 가서 청소한다.
                    if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                    if (arr[nr][nc] != 0) continue;
                    r = nr;
                    c = nc;
                    cnt++;
                    arr[r][c] = 2;
                    flag = false;
                    d = (d+i) %4;
                    break;
                }

                // 청소할 수 있는 칸이 없으면 후진한다.
                if (flag) {
                    int nr = r + dr[(d + 2) % 4];
                    int nc = c + dc[(d + 2) % 4];
                    if (nr < 0 || nr >= N || nc < 0 || nc >= M || arr[nr][nc] == 1) {
                        System.out.println(cnt);
                        return;
                    }
                    r = nr;
                    c = nc;
                }
            }
        }
    }
}
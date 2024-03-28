import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static char[][] campus;
    static boolean[][] visit;
    static int N;
    static int M;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] point = br.readLine().split(" ");
        N = Integer.parseInt(point[0]);
        M = Integer.parseInt(point[1]);
        campus = new char[N][M];
        visit = new boolean[N][M];
        int doyeon_i = 0, doyeon_j = 0;

        // init
        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                campus[i][j] = split[j].charAt(0);

                // 도연이 위치 초기화
                if (campus[i][j] == 'I') {
                    doyeon_i = i;
                    doyeon_j = j;
                }

                // 해당 좌표가 벽이면 방문처리
                if (campus[i][j] == 'X') visit[i][j] = true;
            }
        }

        start(doyeon_i,doyeon_j);

        if (cnt == 0) System.out.println("TT");
        else System.out.println(cnt);
    }


    private static void start(int i, int j) {
        if (check(i, j)) {
            visit[i][j] = true;
            if (campus[i][j] == 'P') cnt++;
            start(i+1, j);
            start(i-1, j);
            start(i, j+1);
            start(i, j-1);
        }
    }

    // 해당 좌표가 배열 범위를 벗어나거나 이미 방문했던 곳이면 false
    private static boolean check(int i, int j) {
        if (i >= N || j >= M || i < 0 || j < 0 || visit[i][j]) return false;
        return true;
    }
}
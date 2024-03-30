import java.io.*;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][][] arr;
    static boolean[][][] visit;
    static int N;
    static int M;
    static int H;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        arr = new int[N][M][H];
        visit = new boolean[N][M][H];
        int day = -1;

        Queue<int[]> queue = new LinkedList<>();

        // 초기화
        for (int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    arr[i][j][k] = Integer.parseInt(st.nextToken());

                    // 만약 익은 토마토면 해당하는 좌표를 큐에 넣고 방문 처리
                    if (arr[i][j][k] == 1) {
                        queue.add(new int[]{i, j, k});
                        visit[i][j][k] = true;
                    }
                }
            }
        }


        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i1 = 0; i1 < size; i1++) {
                int[] point = queue.poll();
                int i = point[0];
                int j = point[1];
                int k = point[2];
                arr[i][j][k] = 1;

                if (check(i+1,j,k)) {
                    queue.add(new int[]{i + 1, j,k});
                    visit[i + 1][j][k] = true;
                }
                if (check(i-1,j,k)) {
                    queue.add(new int[]{i - 1, j,k});
                    visit[i - 1][j][k] = true;
                }
                if (check(i,j+1,k)) {
                    queue.add(new int[]{i, j+1,k});
                    visit[i][j+1][k] = true;
                }
                if (check(i,j-1,k)) {
                    queue.add(new int[]{i, j-1,k});
                    visit[i][j-1][k] = true;
                }
                if (check(i,j,k+1)) {
                    queue.add(new int[]{i, j,k+1});
                    visit[i][j][k+1] = true;
                }
                if (check(i,j,k-1)) {
                    queue.add(new int[]{i, j,k-1});
                    visit[i][j][k-1] = true;
                }
            }
            day++;
        }

        // 0인 곳이 있으면 방문이 불가능한 곳이 있었다는 것
        for (int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (arr[i][j][k] == 0) {
                        System.out.print(-1);
                        return;
                    }
                }
            }
        }
        System.out.print(day);

    }

    // 범위를 벗어나면 안됨 && 방문했던 곳이면 안됨 && 값이 -1 인 곳이면 안됨
    private static boolean check(int i, int j, int k) {
        if (k>=0&&k<H&&i>=0&&j>=0&&i<N&&j<M&&!visit[i][j][k]&&arr[i][j][k]!=-1) return true;
        return false;
    }
}
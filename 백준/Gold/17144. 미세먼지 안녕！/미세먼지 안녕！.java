import java.io.*;
import java.util.*;

public class Main {

    static int[][] arr;
    static List<int[]> clean = new ArrayList<>();
    static Queue<int[]> queue = new LinkedList<>();
    static int N;
    static int M;
    static int sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                if (arr[i][j] != -1 && arr[i][j] != 0) {
                    sum += arr[i][j];
                    queue.add(new int[]{i, j});
                }

                if (arr[i][j] == -1)
                    clean.add(new int[]{i, j});
            }
        }

        while (T-- > 0) {
            int size = queue.size();
            int[][] arr_2 = new int[N][M];

            for (int[] ints : clean) {
                arr_2[ints[0]][ints[1]] = -1;
            }


            // 1회 확산
            while (size-- > 0) {
                int[] point = queue.remove();
                int i = point[0];
                int j = point[1];

                int dust = arr[i][j];
                int cnt = 0;

                if (check(i+1, j) && dust >= 5) {
                    cnt++;
                    arr_2[i+1][j] += dust / 5;
                }
                if (check(i-1, j) && dust >= 5) {
                    cnt++;
                    arr_2[i-1][j] += dust / 5;
                }
                if (check(i, j+1) && dust >= 5) {
                    cnt++;
                    arr_2[i][j+1] += dust / 5;
                }
                if (check(i, j-1) && dust >= 5) {
                    cnt++;
                    arr_2[i][j-1] += dust / 5;
                }

                arr_2[i][j] += dust - ((dust / 5) * cnt);
            }


            // 1회 공기청정기 가동
            int[] point = clean.get(0);
            sum -= arr_2[point[0]-1][0];
            for (int i = point[0]-1; i > 0; i--) arr_2[i][0] = arr_2[i - 1][0];
            for (int i = 0; i <M-1; i++) arr_2[0][i] = arr_2[0][i+1];
            for (int i = 0; i < point[0]; i++) arr_2[i][M-1] = arr_2[i+1][M-1];
            for (int i = M-1; i > 1; i--) arr_2[point[0]][i] = arr_2[point[0]][i-1];
            arr_2[point[0]][1] = 0;

            point = clean.get(1);
            sum -= arr_2[point[0]+1][0];
            for (int i = point[0]+1; i < N-1; i++) arr_2[i][0] = arr_2[i + 1][0];
            for (int i = 0; i <M-1; i++) arr_2[N-1][i] = arr_2[N-1][i+1];
            for (int i = N-1; i > point[0]; i--) arr_2[i][M-1] = arr_2[i-1][M-1];
            for (int i = M-1; i > 1; i--) arr_2[point[0]][i] = arr_2[point[0]][i-1];
            arr_2[point[0]][1] = 0;

            // queue add
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    arr[i][j] = arr_2[i][j];
                    if (arr_2[i][j] != -1 && arr_2[i][j] != 0)
                        queue.add(new int[]{i, j});
                }
            }
        }

        System.out.println(sum);
    }


    static boolean check(int i, int j) {
        if (i >= 0 && j >= 0 && i < N && j < M && arr[i][j] != -1) return true;
        return false;
    }
}
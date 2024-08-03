import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int[][] arr;
    static int[][] list;
    static ArrayDeque<int[]> teacherList = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        list = new int[3][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                char token = st.nextToken().charAt(0);
                if (token == 'S') arr[i][j] = 1;
                if (token == 'T'){
                    arr[i][j] = 2;
                    teacherList.add(new int[]{i, j});
                }
            }
        }

        for (int i = 0; i < N*N; i++) {
            list[0][0] = i / N;
            list[0][1] = i % N;
            if (arr[list[0][0]][list[0][1]] != 0) continue;
            arr[list[0][0]][list[0][1]] = 3;

            for (int j = i+1; j < N * N; j++) {
                list[1][0] = j / N;
                list[1][1] = j % N;
                if (arr[list[1][0]][list[1][1]] != 0) continue;
                arr[list[1][0]][list[1][1]] = 3;

                for (int k = j+1; k < N * N; k++) {
                    list[2][0] = k / N;
                    list[2][1] = k % N;
                    if (arr[list[2][0]][list[2][1]] != 0) continue;
                    arr[list[2][0]][list[2][1]] = 3;

                    if (check()) {
                        System.out.print("YES");
                        return;
                    }
                    arr[list[2][0]][list[2][1]] = 0;

                }
                arr[list[1][0]][list[1][1]] = 0;

            }
            arr[list[0][0]][list[0][1]] = 0;

        }
        System.out.print("NO");
    }

    private static boolean check() {

        for (int[] ints : teacherList) {
            int ti = ints[0];
            int tj = ints[1];

            for (int i = ti; i < N; i++) {
                if (arr[i][tj] == 3) break;
                if (arr[i][tj] == 1) return false;
            }
            for (int i = ti; i >= 0; i--) {
                if (arr[i][tj] == 3) break;
                if (arr[i][tj] == 1) return false;
            }
            for (int j = tj; j < N; j++) {
                if (arr[ti][j] == 3) break;
                if (arr[ti][j] == 1) return false;
            }
            for (int j = tj; j >= 0; j--) {
                if (arr[ti][j] == 3) break;
                if (arr[ti][j] == 1) return false;
            }
        }

        return true;
    }
}
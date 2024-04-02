import java.io.*;
import java.util.*;

public class Main {

    static int[][] arr;
    static int[][] virtual;
    static List<int[]> virus = new ArrayList<>();
    static Queue<int[]> queue = new LinkedList<>();
    static int N;
    static int M;
    static int cnt;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                if (arr[i][j] == 2)
                    virus.add(new int[]{i, j});
            }
        }

        start(0, 0, 0);

        System.out.print(max);


    }

    private static void start(int I, int J, int select) {
        if (select == 3) {
            virtual = new int[N][M];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    virtual[i][j] = arr[i][j];
                }
            }

//            for (int[] ints : virtual) {
//                for (int anInt : ints) {
//                    System.out.print(anInt + " ");
//                }
//                System.out.println();
//            }

            for (int[] ints : virus) {
                queue.add(ints);
            }

            while (!queue.isEmpty()) {
                int[] ints = queue.remove();

                int i = ints[0];
                int j = ints[1];

//                System.out.print("i = " + i);
//                System.out.println("  j = " + j);

                if (check(i+1, j)) {
                    virtual[i+1][j] = 2;
                    queue.add(new int[]{i+1, j});
                }
                if (check(i-1, j)) {
                    virtual[i-1][j] = 2;
                    queue.add(new int[]{i-1, j});
                }
                if (check(i, j+1)) {
                    virtual[i][j+1] = 2;
                    queue.add(new int[]{i, j+1});
                }
                if (check(i, j-1)) {
                    virtual[i][j-1] = 2;
                    queue.add(new int[]{i, j-1});
                }
            }

            cnt = 0;
            for (int[] ints : virtual) {
                for (int i : ints) {
                    if (i == 0) cnt++;
                }
            }
            if (cnt > max) max = cnt;

            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) {
                    arr[i][j] = 1;
                    start(i, j, select+1);
                    arr[i][j] = 0;
                }
            }
        }
    }

    static boolean check(int i, int j) {
        if (i >= 0 && j >= 0 && i < N && j < M && virtual[i][j] == 0) return true;
        return false;
    }
}
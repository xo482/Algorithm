import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int[][] arr;
    static int N;
    static int M;
    static int max=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) for (int j = 0; j < M; j++) solution(i, j);

        System.out.println(max);
    }


    private static void solution(int i, int j) {
        int sum = 0;
        // 일직선 체크
        if (check(i + 1, j) && check(i + 2, j) && check(i + 3, j)) {
            sum = arr[i][j] + arr[i+1][j] + arr[i+2][j] + arr[i+3][j];
            if (sum > max) max = sum;
        }
        if (check(i, j+1) && check(i, j+2) && check(i, j+3)) {
            sum = arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i][j+3];
            if (sum > max) max = sum;
        }

        // 큰 네모 체크
        if (check(i+1, j) && check(i+1, j+1) && check(i, j+1)) {
            sum = arr[i][j] + arr[i+1][j] + arr[i+1][j+1] + arr[i][j+1];
            if (sum > max) max = sum;
        }

        // 산 모양 체크
        if (check(i+1, j) && check(i, j+1) && check(i, j-1)) {
            sum = arr[i][j] + arr[i+1][j] + arr[i][j+1] + arr[i][j-1];
            if (sum > max) max = sum;
        }
        if (check(i-1, j) && check(i, j+1) && check(i, j-1)) {
            sum = arr[i-1][j] + arr[i][j+1] + arr[i][j-1] + arr[i][j];
            if (sum > max) max = sum;
        }
        if (check(i, j+1) && check(i-1, j) && check(i+1, j)) {
            sum = arr[i][j] + arr[i][j+1] + arr[i-1][j] + arr[i+1][j];
            if (sum > max) max = sum;
        }
        if (check(i, j-1) && check(i+1, j) && check(i-1, j)) {
            sum = arr[i][j] + arr[i][j-1] + arr[i+1][j] + arr[i-1][j];
            if (sum > max) max = sum;
        }

        // ㄱ자 모양 체크
        if (check(i+1, j) && check(i+2, j)) {
            if (check(i + 2, j + 1)) {
                sum = arr[i][j] + arr[i+1][j] + arr[i+2][j] + arr[i+2][j+1];
                if (sum > max) max = sum;
            }
            if (check(i + 2, j - 1)) {
                sum = arr[i][j] + arr[i+1][j] + arr[i+2][j] + arr[i+2][j-1];
                if (sum > max) max = sum;
            }
        }
        if (check(i-1, j) && check(i-2, j)) {
            if (check(i - 2, j + 1)) {
                sum = arr[i][j] + arr[i-1][j] + arr[i-2][j] + arr[i-2][j+1];
                if (sum > max) max = sum;
            }
            if (check(i - 2, j - 1)) {
                sum = arr[i][j] + arr[i-1][j] + arr[i-2][j] + arr[i-2][j-1];
                if (sum > max) max = sum;
            }
        }
        if (check(i, j+1) && check(i, j+2)) {
            if (check(i + 1, j + 2)) {
                sum = arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i+1][j+2];
                if (sum > max) max = sum;
            }
            if (check(i - 1, j + 2)) {
                sum = arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i-1][j+2];
                if (sum > max) max = sum;
            }
        }
        if (check(i, j-1) && check(i, j-2)) {
            if (check(i + 1, j - 2)) {
                sum = arr[i][j] + arr[i][j-1] + arr[i][j-2] + arr[i+1][j-2];
                if (sum > max) max = sum;
            }
            if (check(i - 1, j - 2)) {
                sum = arr[i][j] + arr[i][j-1] + arr[i][j-2] + arr[i-1][j-2];
                if (sum > max) max = sum;
            }
        }

        //치지직 모양 체크
        if (check(i+1, j)) {
            if (check(i+1, j+1) && check(i+2, j+1)) {
                sum = arr[i][j] + arr[i+1][j] + arr[i+1][j+1] + arr[i+2][j+1];
                if (sum > max) max = sum;
            }
            if (check(i+1, j-1) && check(i+2, j-1)) {
                sum = arr[i][j] + arr[i+1][j] + arr[i+1][j-1] + arr[i+2][j-1];
                if (sum > max) max = sum;
            }
        }
        if (check(i-1, j)) {
            if (check(i-1, j-1) && check(i-2, j-1)) {
                sum = arr[i][j] + arr[i-1][j] + arr[i-1][j-1] + arr[i-2][j-1];
                if (sum > max) max = sum;
            }
            if (check(i-1, j+1) && check(i-2, j+1)) {
                sum = arr[i][j] + arr[i-1][j] + arr[i-1][j+1] + arr[i-2][j+1];
                if (sum > max) max = sum;
            }
        }
        if (check(i, j+1)) {
            if (check(i-1, j+1) && check(i-1, j+2)) {
                sum = arr[i][j] + arr[i][j+1] + arr[i-1][j+1] + arr[i-1][j+2];
                if (sum > max) max = sum;
            }
            if (check(i+1, j+1) && check(i+1, j+2)) {
                sum = arr[i][j] + arr[i][j+1] + arr[i+1][j+1] + arr[i+1][j+2];
                if (sum > max) max = sum;
            }
        }
        if (check(i, j-1)) {
            if (check(i-1, j-1) && check(i-1, j-2)) {
                sum = arr[i][j] + arr[i][j-1] + arr[i-1][j-1] + arr[i-1][j-2];
                if (sum > max) max = sum;
            }
            if (check(i+1, j-1) && check(i+1, j-2)) {
                sum = arr[i][j] + arr[i][j-1] + arr[i+1][j-1] + arr[i+1][j-2];
                if (sum > max) max = sum;
            }
        }
    }

    private static boolean check(int i, int j) {
        if (i >= 0 && i < N && j >= 0 && j < M) return true;
        return false;
    }

}

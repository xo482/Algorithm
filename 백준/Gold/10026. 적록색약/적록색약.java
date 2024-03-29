import java.io.*;

public class Main {

    static char[][] arr;
    static boolean[][] visit;
    static boolean[][] visit2;
    static int N;
    static int R = 0, G = 0, B = 0;
    static int RG2 = 0, B2 = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        visit = new boolean[N][N];
        visit2 = new boolean[N][N];

        // init
        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                arr[i][j] = split[j].charAt(0);
            }
        }

        //
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (check(i,j))
                    start(i,j, 'N');
            }
        }
        System.out.println(R+G+B);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (check2(i,j))
                    start2(i,j, 'N');
            }
        }
        System.out.println(RG2+B2);
    }

    private static void start2(int i, int j, char c) {
        if (c == 'N') {
            c = arr[i][j];

            if (c == 'R' || c == 'G') RG2++;
            if (c == 'B') B2++;
        }

        visit2[i][j] = true;

        if (c == 'R' || c == 'G') {
            if (check2(i+1, j) && (arr[i+1][j] == 'R' || arr[i+1][j] == 'G'))
                start2(i+1, j, c);
            if (check2(i-1, j) && (arr[i-1][j] == 'R' || arr[i-1][j] == 'G'))
                start2(i-1, j, c);
            if (check2(i, j+1) && (arr[i][j+1] == 'R' || arr[i][j+1] == 'G'))
                start2(i, j+1, c);
            if (check2(i, j-1) && (arr[i][j-1] == 'R' || arr[i][j-1] == 'G'))
                start2(i, j-1, c);
        }else {
            if (check2(i+1, j) && arr[i+1][j] == c)
                start2(i+1, j, c);
            if (check2(i-1, j) && arr[i-1][j] == c)
                start2(i-1, j, c);
            if (check2(i, j+1) && arr[i][j+1] == c)
                start2(i, j+1, c);
            if (check2(i, j-1) && arr[i][j-1] == c)
                start2(i, j-1, c);
        }
    }

    private static void start(int i, int j, char c) {

        if (c == 'N') {
            c = arr[i][j];

            if (c == 'R') R++;
            if (c == 'G') G++;
            if (c == 'B') B++;
        }

        visit[i][j] = true;

        if (check(i+1, j) && arr[i+1][j] == c)
            start(i+1, j, c);
        if (check(i-1, j) && arr[i-1][j] == c)
            start(i-1, j, c);
        if (check(i, j+1) && arr[i][j+1] == c)
            start(i, j+1, c);
        if (check(i, j-1) && arr[i][j-1] == c)
            start(i, j-1, c);
    }

    private static boolean check(int i, int j) {
        if (i < 0 || j < 0 || i >= N || j >= N || visit[i][j]) return false;
        return true;
    }
    private static boolean check2(int i, int j) {
        if (i < 0 || j < 0 || i >= N || j >= N || visit2[i][j]) return false;
        return true;
    }
}
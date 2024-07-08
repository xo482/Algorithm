import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int min = Integer.MAX_VALUE;
    static int[][] S;
    static boolean[] list;
    static int[] team1;
    static int[] team2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        S = new int[N][N];
        list = new boolean[N];
        team1 = new int[N / 2];
        team2 = new int[N / 2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0,0);
        System.out.println(min/2);
    }

    private static void dfs(int depth, int h) {
        if (depth == N / 2) {
            int j=0, k=0;

            for (int i = 0; i < N; i++) {
                if (list[i]) {
                    team1[j++] = i;
                } else {
                    team2[k++] = i;
                }
            }

            int t1Sum = calculate(team1);
            int t2Sum = calculate(team2);


            if (min > t1Sum - t2Sum && t1Sum - t2Sum >= 0) {
                min = t1Sum - t2Sum;
            }

            return;
        }

        for (int i = h; i < N; i++) {
            if (!list[i]) {
                list[i] = true;
                dfs(depth + 1, i);
                list[i] = false;
            }
        }
    }

    private static int calculate(int[] team) {
        int sum = 0;

        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < N / 2; j++) {
                sum += S[team[i]][team[j]];
                sum += S[team[j]][team[i]];
            }
        }

        return sum;
    }


}
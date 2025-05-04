import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, K;
    static int[][] belt;
    static int cnt = 0, cycle = 0;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        belt = new int[2*N][2]; // 0 내구도, 1 로봇유무

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * N; i++) belt[i][0] = Integer.parseInt(st.nextToken());

        while (cnt < K) {
            turn();
            moveRobot();
            addRobot();

            cycle++;
        }

        System.out.println(cycle);
    }

    private static void addRobot() {
        if (belt[0][0] == 0) return;

        belt[0][1] = 1;
        belt[0][0]--;
        check(0);
    }

    private static void moveRobot() {
        for (int i = N-2; i >= 0; i--) {
            if (belt[i][1] == 0) continue; // 나한테 로봇이 없음
            if (belt[i+1][1] == 1) continue; // 내 앞에 이미 로봇이 있음
            if (belt[i+1][0] == 0) continue; // 내 앞 땅이 내구도가 0임

            belt[i + 1][1] = belt[i][1];
            belt[i][1] = 0;

            belt[i+1][0]--;
            check(i+1);
        }
        eraseRobot();
    }

    private static void check(int i) {
        if (belt[i][0] == 0) cnt++;
    }

    private static void eraseRobot() {
        belt[N-1][1] = 0;
    }

    private static void turn() {
        int temp1 = belt[2 * N - 1][0];
        int temp2;

        int temp3 = belt[2 * N - 1][1];
        int temp4;

        for (int i = 0; i < 2 * N; i++) {
            temp2 = belt[i][0];
            belt[i][0] = temp1;
            temp1 = temp2;

            temp4 = belt[i][1];
            belt[i][1] = temp3;
            temp3 = temp4;
        }

        eraseRobot();
    }

}

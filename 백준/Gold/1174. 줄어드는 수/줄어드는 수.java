import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int cnt = 0;
    static boolean flag = false;
    static long answer = -1;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= 10; i++) {
            if (flag) break;
            tracking(0, 10, i);
        }
        System.out.println(answer);
    }

    private static void tracking(long num, int max, int depth) {
        if (depth == 0) {
            cnt++;
            if (cnt == N) {
                answer = num;
                flag = true;
                return;
            }
        }

        for (int i = 0; i < max; i++) {
            tracking((long) (num + i * Math.pow(10, depth - 1)), i, depth - 1);
            if (flag) break;
        }
    }
}
import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        tracking(0, 0);
        System.out.print(sb);
    }

    private static void tracking(int depth, int num) {

        if (depth == N) {
            sb.append(num / 10).append("\n");
            return;
        }

        for (int i = 1; i < 10; i++) {
            // 소수 판정
            if (check(num + i)) continue;
            tracking(depth + 1, (num + i) * 10);
        }
    }

    private static boolean check(int num) {

        if (num == 1) {
            return true;
        }
        if (num == 2) {
            return false;
        }

        boolean flag = false;
        for (int i = 2; i <= num/2; i++) {
            if (num % i == 0) {
                flag = true;
                break;
            }
        }

        return flag;
    }
}
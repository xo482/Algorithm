import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N;
    static int min = 1000000000, max = -1000000000;
    static int[] nums, ops;
    static char[] setting;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        nums = new int[N];
        setting = new char[N-1];
        ops = new int[4];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) nums[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) ops[i] =  Integer.parseInt(st.nextToken());


        tracking(0);
        System.out.println(max + "\n" + min);
    }

    static void tracking(int depth) {
        if (depth == N-1) {
            int now = calculate();
            min = Math.min(min, now);
            max = Math.max(max, now);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (ops[i] == 0) continue;

            if (i == 0) setting[depth] = '+';
            if (i == 1) setting[depth] = '-';
            if (i == 2) setting[depth] = '*';
            if (i == 3) setting[depth] = '/';
            ops[i]--;

            tracking(depth+1);

            ops[i]++;
        }
    }

    static int calculate() {
        int answer = nums[0];
        for (int i = 1; i < N; i++) {
            if (setting[i-1] == '+') answer = answer + nums[i];
            if (setting[i-1] == '-') answer = answer - nums[i];
            if (setting[i-1] == '*') answer = answer * nums[i];
            if (setting[i-1] == '/') answer = answer / nums[i];
        }
        return answer;
    }
}

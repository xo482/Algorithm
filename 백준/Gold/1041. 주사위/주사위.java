import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static long N;
    static int[] dice = new int[6];

    public static void main(String[] args) throws Exception {
        N = Long.parseLong(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) dice[i] = Integer.parseInt(st.nextToken());


        long sum123 = 150L;
        sum123 = Math.min(sum123, dice[0] + dice[1] + dice[2]);
        sum123 = Math.min(sum123, dice[0] + dice[2] + dice[4]);
        sum123 = Math.min(sum123, dice[0] + dice[4] + dice[3]);
        sum123 = Math.min(sum123, dice[0] + dice[3] + dice[1]);
        sum123 = Math.min(sum123, dice[5] + dice[1] + dice[2]);
        sum123 = Math.min(sum123, dice[5] + dice[2] + dice[4]);
        sum123 = Math.min(sum123, dice[5] + dice[4] + dice[3]);
        sum123 = Math.min(sum123, dice[5] + dice[3] + dice[1]);

        long sum12 = 100L;
        sum12 = Math.min(sum12, dice[0] + dice[1]);
        sum12 = Math.min(sum12, dice[0] + dice[2]);
        sum12 = Math.min(sum12, dice[0] + dice[3]);
        sum12 = Math.min(sum12, dice[0] + dice[4]);
        sum12 = Math.min(sum12, dice[5] + dice[1]);
        sum12 = Math.min(sum12, dice[5] + dice[2]);
        sum12 = Math.min(sum12, dice[5] + dice[3]);
        sum12 = Math.min(sum12, dice[5] + dice[4]);
        sum12 = Math.min(sum12, dice[1] + dice[2]);
        sum12 = Math.min(sum12, dice[2] + dice[4]);
        sum12 = Math.min(sum12, dice[4] + dice[3]);
        sum12 = Math.min(sum12, dice[3] + dice[1]);

        Arrays.sort(dice);
        long sum1 = dice[0];

        if (N == 1) {
            System.out.println(dice[0] + dice[1] + dice[2] + dice[3] + dice[4]);
            return;
        }

        long answer = 0;
        answer += 4 * sum123;
        answer += 4 * (N - 2) * sum12;
        answer += (N - 2) * (N - 2) * sum1;
        answer += 4 * (N - 1) * sum12;
        answer += 4 * (N - 1) * (N - 2) * sum1;

        System.out.println(answer);
    }

}
//  3
//4 0  1 5
//  2
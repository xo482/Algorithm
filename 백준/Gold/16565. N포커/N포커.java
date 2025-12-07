import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, MOD = 10007;
    static long ans = 0;
    static long[] arr;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        arr = new long[N / 4 + 1];

        if (N < 4) {
            System.out.println(0);
            return;
        }

        for (int i = 1; i <= N / 4; i++) {
            arr[i] = comb(13, i) * comb(52 - (4L * i), N - (4L * i));
            arr[i] %= MOD;

            if (i % 2 == 1) ans += arr[i];
            if (i % 2 == 0) ans -= arr[i];
        }

        System.out.println((ans % MOD + MOD) % MOD);
    }

    static long comb(long a, long b) {
        b = Math.min(b, a - b);
        long res = 1;

        for (int i = 1; i <= b; i++) {
            res = res * (a - b + i) / i;
        }

        return res;
    }
}
import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static long M;
    static List<Long> dp = new ArrayList<>();
    static String str = "Messi Gimossi";
    static String ans =  "Messi Messi Gimossi";

    public static void main(String[] args) throws IOException {
        dp.add(5L);
        dp.add(13L);
        M = Long.parseLong(br.readLine());

        while (dp.get(dp.size() - 1) < M) {
            int size = dp.size();
            long n1 = dp.get(size - 1);
            long n2 = dp.get(size - 2);
            dp.add(n1 + n2 + 1);
        }

        tracking(dp.size() - 1, M);
        System.out.println(ans);
    }

    static void tracking(int idx, long m) {
        if (m <= 13) {
            if (m != 6) ans = "" + str.charAt((int) m - 1);
            return;
        }
        Long size = dp.get(idx - 1);

        if (size >= m) {
            tracking(idx - 1, m);
        }
        if (size + 1 == m) {
            return;
        }
        if (size + 1 < m) {
            tracking(idx - 2, m - (size + 1));
        }
    }
}
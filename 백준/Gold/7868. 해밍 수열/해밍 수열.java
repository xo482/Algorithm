import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static long p1, p2, p3, I;
    static List<Long> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        p1 = Long.parseLong(st.nextToken());
        p2 = Long.parseLong(st.nextToken());
        p3 = Long.parseLong(st.nextToken());
        I = Long.parseLong(st.nextToken());

        long x = 1;
        int c_1 = 0;
        while (x <= Long.MAX_VALUE / p1) {
            x *= p1;
            c_1++;
        }

        x = 1;
        int c_2 = 0;
        while (x <= Long.MAX_VALUE / p2) {
            x *= p2;
            c_2++;
        }

        x = 1;
        int c_3 = 0;
        while (x <= Long.MAX_VALUE / p3) {
            x *= p3;
            c_3++;
        }

        for (int i = 0; i <= c_1; i++) {
            for (int j = 0; j <= c_2; j++) {
                for (int k = 0; k <= c_3; k++) {

                    long pow_1 = (long) Math.pow(p1, i);
                    long pow_2 = (long) Math.pow(p2, j);
                    long pow_3 = (long) Math.pow(p3, k);

                    BigInteger n1 = new BigInteger(String.valueOf(pow_1));
                    BigInteger n2 = new BigInteger(String.valueOf(pow_2));
                    BigInteger n3 = new BigInteger(String.valueOf(pow_3));
                    BigInteger MAX = new BigInteger(String.valueOf(Long.MAX_VALUE));
                    if (n1.multiply(n2.multiply(n3)).compareTo(MAX) == 1) continue;

                    list.add(pow_1 * pow_2 * pow_3);
                }
            }
        }

        Collections.sort(list);
        System.out.println(list.get((int) I));
    }
}
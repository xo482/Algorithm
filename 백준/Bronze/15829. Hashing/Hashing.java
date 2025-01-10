import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static long L;
    static long M = 1234567891L;
    static long R = 31L;

    public static void main(String[] args) throws IOException {
        L = Long.parseLong(br.readLine());
        String str = br.readLine();

        long sum = 0;
        for (int i = 0; i < L; i++) {
            sum += ((str.charAt(i) - 'a' + 1) * (long)Math.pow(R, i));
            if (sum > M) sum %= M;
        }

        System.out.println(sum);
    }
}
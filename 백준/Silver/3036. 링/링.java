import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int first = Integer.parseInt(st.nextToken());
        while (N-- > 1) {
            int nxt = Integer.parseInt(st.nextToken());
            int gcd = gcd(first, nxt);
            sb.append((first/gcd) + "/" + (nxt/gcd)).append('\n');
        }
        System.out.print(sb);
    }

    private static int gcd(int a, int b) {
        int temp;
        while (b != 0) {
            temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int a, b;
    static int[][][] board;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        int x = a;
        int y = b;

        while (y != 0) {
            int mod = x % y;
            x = y;
            y = mod;
        }
        System.out.println(x + "\n" + a*b/x);
    }
}
import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static long N, A;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        A = Long.parseLong(st.nextToken());

        sb.append(N - A).append(" ");
        sb.append(executeGCD(N, A, 0, 1));

        System.out.println(sb);
    }

    static long executeGCD(long n, long a, long x, long y) {
        if (a == 0){
            if (n==1) return (x > 0) ? x : x + N;
            else return -1;
        }

        return executeGCD(a, n % a, y, x-(n/a)*y);
    }
}
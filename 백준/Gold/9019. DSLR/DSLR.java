import java.util.*;
import java.io.*;


/**
 *  D, S, L, R 을 이용하는 간단한 계산기.
 *  레지스터 0 이상 10,000 미만의 십진수 저장 가능.
 *
 */

public class Main{
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            ArrayDeque<Integer> Q = new ArrayDeque<>();
            String[] list = new String[10_000];
            list[A] = "";
            Q.addLast(A);

            while (!Q.isEmpty()) {
                int n = Q.removeFirst();
                int D = D(n);
                int S = S(n);
                int L = L(n);
                int R = R(n);

                if (list[D] == null) {
                    list[D] = list[n] + "D";
                    Q.addLast(D);
                }
                if (list[S] == null) {
                    list[S] = list[n] + "S";
                    Q.addLast(S);
                }
                if (list[L] == null) {
                    list[L] = list[n] + "L";
                    Q.addLast(L);
                }
                if (list[R] == null) {
                    list[R] = list[n] + "R";
                    Q.addLast(R);
                }
            }

            sb.append(list[B]).append("\n");
        }

        System.out.print(sb);
    }

    public static int D(int n) {
        return (n >= 5000) ? 2 * n % 10_000 : 2 * n;
    }

    public static int S(int n) {
        return (n == 0) ? 9999 : n - 1;
    }

    public static int L(int n) {
        return n % 1_000 * 10 + n / 1_000;
    }

    public static int R(int n) {
        return (n % 10) * 1000 + n / 10;
    }
}
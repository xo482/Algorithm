import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int T;
    static boolean[] isPrime = new boolean[5001];
    static List<Integer> primeList = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        initPrime();

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {

            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            sb.append(solveCoprime(n1, r1, n2, r2)).append('\n');
        }

        System.out.println(sb);
    }

    private static void initPrime() {
        for (int i = 2; i * i < 5001; i++) {
            if (!isPrime[i]) {
                for (int j = i*i; j < 5001; j+=i) {
                    isPrime[j] = true;
                }
            }
        }

        for (int i = 2; i < 5001; i++) {
            if (!isPrime[i]) primeList.add(i);
        }
    }

    // p에 대한 n!의 지수를 구하는 헬퍼
    private static int countFactorInFactorial(int n, int p) {
        int cnt = 0;
        while (n > 0) {
            n /= p;
            cnt += n;
        }
        return cnt;
    }

    // C(n,r)에 대한 p의 지수: ν_p(n!) - ν_p(r!) - ν_p((n-r)!)
    private static int getBinomialExponent(int n, int r, int p) {
        return countFactorInFactorial(n, p)
                - countFactorInFactorial(r, p)
                - countFactorInFactorial(n - r, p);
    }

    public static int solveCoprime(int n1, int r1, int n2, int r2) {
        // 대칭성 때문에 r > n/2인 경우 r ← n-r 로 치환해도 무방
        if (r1 > n1 - r1) r1 = n1 - r1;
        if (r2 > n2 - r2) r2 = n2 - r2;

        for (int p : primeList) {
            if (p > n1 && p > n2) break;
            // p가 둘 다 n보다 크면 더 이상 확인할 필요 없음

            int e1 = (p <= n1)
                    ? getBinomialExponent(n1, r1, p)
                    : 0;
            if (e1 == 0) continue;

            int e2 = (p <= n2)
                    ? getBinomialExponent(n2, r2, p)
                    : 0;
            if (e2 > 0) {
                return 0;
            }
        }
        return 1;
    }

}

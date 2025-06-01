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

    // n! 안에 p라는 소수가 몇개 들어 있는지 찾음 (레장드르)
    private static int countFactorInFactorial(int n, int p) {
        int cnt = 0;
        while (n > 0) {
            n /= p;
            cnt += n;
        }
        return cnt;
    }
    
    private static int getBinomialExponent(int n, int r, int p) {
        return countFactorInFactorial(n, p)
                - countFactorInFactorial(r, p)
                - countFactorInFactorial(n - r, p);
    }

    public static int solveCoprime(int n1, int r1, int n2, int r2) {
        for (int p : primeList) {
            // 판별할 소수가 두 수보다 크면 끝냄
            if (p > n1 && p > n2) break;

            int e1 = getBinomialExponent(n1, r1, p);
            if (e1 == 0) continue; // 굳이 오른쪽 볼 필요 x

            int e2 = getBinomialExponent(n2, r2, p);
            if (e2 > 0) return 0; // 둘다 1개 이상 p를 가지고 있음
        }
        return 1;
    }

}

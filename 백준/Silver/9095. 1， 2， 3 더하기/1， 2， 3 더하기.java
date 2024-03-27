import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int cnt = 0;

            for (int i = 0; i <= N / 3; i++) { // i 는 3의 개수
                 int M = N - (3*i); // 3으로 작업하고 남은 거
                for (int j = 0; j <= M / 2; j++) { // j 는 2의 개수
                    int k = M - (2*j);

                    cnt += factorial(i+j+k) / factorial(i) / factorial(j) / factorial(k);
                }

            }

            sb.append(cnt).append("\n");
        }
        System.out.print(sb);
    }

    private static int factorial(int N) {
        int res = 1;
        for (int i = 1; i <= N; i++) {
            res *= i;
        }
        return res;
    }
}

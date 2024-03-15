import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int A = Integer.parseInt(s[0]);
        int B = Integer.parseInt(s[1]);
        int underPrime = 0;

        for (int i = A; i <= B; i++) {
            int now = i;
            int cnt = 0;
            int divider = 2;

            while (now > 1) {
                if (i == divider) break;
                if (now % divider == 0) {
                    now /= divider;
                    cnt++;
                } else divider++;
            }

            if (cnt < 2) continue;

            // 소수의 개수가 소수인지 확인
            underPrime++;
            for (int j = 2; j < cnt; j++) {
                if (cnt % j == 0) {
                    underPrime--;
                    break;
                }
            }
        }

        System.out.println(underPrime);

    }
}

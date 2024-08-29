import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        BigInteger answer = new BigInteger("1");

        for (int i = K+1; i <= N; i++) {
            answer = answer.multiply(BigInteger.valueOf(i));
        }

        for (int i = 1; i <= N-K; i++) {
            answer = answer.divide(BigInteger.valueOf(i));
        }

        System.out.println(answer.remainder(BigInteger.valueOf(10007)));
    }
}
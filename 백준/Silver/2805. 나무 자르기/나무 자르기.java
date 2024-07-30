import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static long sum=0;
    static int[] arr;
    static int MIN = 0;
    static int MAX = 1_000_000_000;
    static int height = 500_000_000;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        while (true) {
            sum = 0;
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                if (arr[i] > height) {
                    sum += arr[i] - height;
                    cnt++;
                }
            }

            if (sum < M) {
                MAX = height;
                height = (height + MIN) / 2;
            }
            if (sum > M) {
                if (sum - cnt < M) {
                    break;
                }
                MIN = height;
                height = (height + MAX) / 2;
            }
            if (sum == M) {
                break;
            }
        }

        System.out.print(height);
    }
}
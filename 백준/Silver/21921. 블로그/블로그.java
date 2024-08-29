import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int sum = 0, max = 0, cnt = 0;
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        for (int i = 0; i < X; i++) sum += arr[i]; // 초기 sum 값 세팅
        max = sum;
        cnt++;

        for (int i = X; i < N; i++) {
            sum -= arr[i-X];
            sum += arr[i];

            if (sum > max) {
                max = sum;
                cnt = 0;
            }
            if (sum == max) cnt++;
        }

        if (max == 0) System.out.print("SAD");
        else System.out.print(max + "\n" + cnt);
    }
}
import java.io.*;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int[] arr, LIS;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        LIS = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        LIS[0] = arr[0];
        int idx = 0;
        for (int i = 1; i < N; i++) {

            int now = arr[i];

            if (now > LIS[idx]) {
                idx++;
                LIS[idx] = now;
                continue;
            }

            int start = 0;
            int end = idx;
            while (start < end) {
                int mid = (start + end) / 2;

                if (LIS[mid] < now) start = mid+1;
                else end = mid;
            }

            LIS[start] = now;
        }

        System.out.println(idx+1);
    }
}
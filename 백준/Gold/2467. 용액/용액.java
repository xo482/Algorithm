import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, min = 2000000001, answer1, answer2;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);

        for (int idx1 = 0; idx1 < N - 1; idx1++) {
            int start = idx1+1;
            int end = N-1;
            int idx2 = 0;
            while (start <= end) {
                idx2 = (start + end) / 2;
                int sum = arr[idx1] + arr[idx2];

                if (sum > 0) {
                    end = idx2 - 1;
                }else {
                    start = idx2 + 1;
                }
            }

            if (idx1 != idx2-1 && Math.abs(arr[idx1] + arr[idx2]) > Math.abs(arr[idx1] + arr[idx2-1])) {
                idx2--;
            }
            if (N != idx2+1 && Math.abs(arr[idx1] + arr[idx2]) > Math.abs(arr[idx1] + arr[idx2+1])) {
                idx2++;
            }

            if (Math.abs(arr[idx1] + arr[idx2]) < min) {
                min = Math.abs(arr[idx1] + arr[idx2]);
                answer1 = arr[idx1];
                answer2 = arr[idx2];
            }
        }
        System.out.println(answer1 + " " + answer2);
    }
}
import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N;
    static int[] arr;
    static int[] answer = new int[3];
    static long min = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);


        for (int idx1 = 0; idx1 < N-2; idx1++) {
            for (int idx2 = idx1+1; idx2 < N - 1; idx2++) {

                int start = idx2 + 1;
                int end = N-1;
                int mid = 0;
                while (start <= end) {
                    mid = (start + end) / 2;
                    long sum = (long)arr[idx1] + (long)arr[idx2] + (long)arr[mid];

                    if (sum > 0) {
                        end = mid - 1;
                    } else {
                        start = mid + 1;
                    }
                }

                int idx3 = mid;
                if (idx2 != idx3-1 && Math.abs((long)arr[idx1] + (long)arr[idx2] + (long)arr[idx3]) > Math.abs((long)arr[idx1] + (long)arr[idx2] + (long)arr[idx3 - 1])) {
                    idx3--;
                }
                if (N != idx3+1 && Math.abs((long)arr[idx1] + (long)arr[idx2] + (long)arr[idx3]) > Math.abs((long)arr[idx1] + (long)arr[idx2] + (long)arr[idx3 + 1])) {
                    idx3++;
                }

                if (min > Math.abs((long)arr[idx1] + (long)arr[idx2] + (long)arr[idx3])) {
                    min = Math.abs((long)arr[idx1] + (long)arr[idx2] + (long)arr[idx3]);
                    answer[0] = arr[idx1];
                    answer[1] = arr[idx2];
                    answer[2] = arr[idx3];
                }
            }
        }

        Arrays.sort(answer);
        System.out.println(answer[0] + " " + answer[1] + " " + answer[2]);
    }
}
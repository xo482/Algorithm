import java.io.*;
import java.util.*;

public class Main {

    static int[] arr;
    static int max = 0;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        int k = 0;
        int len = N*(N+1)/2;
        arr = new int[len];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                arr[k++] = Integer.parseInt(st.nextToken());
            }
        }

        int n = 0;
        int i = 0;
        while(n < N-1) {
            arr[i + n + 1] = arr[i] + arr[i + n + 1];

            for (int j = i; j < i+n; j++) {
                if (arr[j] > arr[j + 1]) {
                    arr[j + n + 2] = arr[j] + arr[j + n + 2];
                } else {
                    arr[j + n + 2] = arr[j+1] + arr[j + n + 2];
                }
            }


            arr[i + n + n + 2] = arr[i + n] + arr[i + n + n + 2];


            i = i + ++n;
        }

        for (int j = i; j <= i+n; j++) {
            if (arr[j] > max) {
                max = arr[j];
            }
        }

        System.out.println(max);

    }
}
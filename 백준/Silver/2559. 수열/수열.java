import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int max = Integer.MIN_VALUE;
        int window = 0;

        // init
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++)
            window += arr[i];

        // logic
        for(int i = 0; i < N-M+1; i++) {
            if(max < window) {
                max = window;
            }

            window -= arr[i];
            if (i + M < N) {
                window += arr[i+M];
            }
        }

        System.out.println(max);
    }
}

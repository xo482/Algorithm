import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+1];
        int max = Integer.MIN_VALUE;
        int window = 0;

        // init
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i < N+1; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        for (int i = 1; i < M; i++)
            window += arr[i];

        // logic
        for(int i = M; i < N+1; i++) {

            window += arr[i];

            if(max < window) {
                max = window;
            }

            window -= arr[i - M + 1];
        }

        System.out.println(max);
    }
}

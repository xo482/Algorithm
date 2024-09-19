import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, S;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        int p1 = 0;
        int p2 = 0;
        int sum = arr[0];
        int min = 100001;
        while (p2 < N) {
            if (sum < S) {
                sum += arr[++p2];
            } else {
                min = Math.min(min, p2 - p1);
                sum -= arr[p1++];
            }
        }
        if (min == 100001) System.out.println(0);
        else System.out.println(min + 1);
    }
}
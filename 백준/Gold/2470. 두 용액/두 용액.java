import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int min = Integer.MAX_VALUE;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);

        int p1 = 0;
        int p2 = N-1;
        int answerP1 = 0;
        int answerP2 = N-1;

        while (p1 < p2) {
            int sum = arr[p1]+arr[p2];
            int abs = Math.abs(sum);

            if (min > abs) {
                min = abs;
                answerP1 = p1;
                answerP2 = p2;
            }
            if (sum == 0) break;
            if (sum < 0) p1++;
            if (sum > 0) p2--;
        }

        System.out.println(arr[answerP1] + " " + arr[answerP2]);
    }
}
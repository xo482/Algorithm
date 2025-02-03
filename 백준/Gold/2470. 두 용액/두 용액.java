import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int[] arr;
    static int answer = Integer.MAX_VALUE;
    static int answerP1, answerP2;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);

        int p1 = 0;
        int p2 = N - 1;
        while (p1 < p2) {
            int now = arr[p1] + arr[p2];
            if (answer > Math.abs(now)) {
                answer = Math.abs(now);
                answerP1 = p1;
                answerP2 = p2;
            }

            if (now == 0) break;
            if (now < 0) p1++;
            if (now > 0) p2--;
        }

        System.out.println(arr[answerP1] + " " + arr[answerP2]);
    }

}
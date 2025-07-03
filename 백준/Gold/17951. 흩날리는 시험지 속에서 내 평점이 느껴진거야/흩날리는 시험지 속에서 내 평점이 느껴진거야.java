import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, K;
    static int[] scores;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        scores = new int[N];

        st = new StringTokenizer(br.readLine());
        int totalScore = 0;
        for (int i = 0; i < N; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
            totalScore += scores[i];
        }

        int start = -1;
        int end = totalScore + 1;
        while (start + 1 < end) {
            int mid = (start + end) / 2;

            // mid 값을 넘는 그룹을 몇개 만들 수 있는지를 본다.
            int groupCnt = 0;
            int sum = 0;
            for (int i = 0; i < N; i++) {
                sum += scores[i];
                if (sum >= mid) {
                    groupCnt++;
                    sum = 0;
                }
            }

            if (groupCnt >= K) start = mid;
            else end = mid;
        }

        System.out.println(start);
    }
}
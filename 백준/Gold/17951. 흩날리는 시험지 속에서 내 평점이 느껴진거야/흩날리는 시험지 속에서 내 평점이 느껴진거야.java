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


        int sum = 0;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            sum += scores[i];
            if (sum >= start) {
                ans = Math.min(ans, sum);
                sum = 0;
            }
        }

        System.out.println(ans);
    }
}

// 휴게소 설치 문제랑 같은 방법으로 풀면 되겠다.
// K개의 그룹 -> 갯수가 없음
// 그러므로 점수의 합을 기준으로 이분 탐색

// 그룹간의 차이가 가장 적어야함 == 각 그룹은 최소한으로 가져가야함
// 그때의 그룹 중 최솟값을 구하는게 최솟값중 가장 큰 값
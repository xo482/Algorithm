import java.io.*;
import java.util.*;

// 선행 관계가 없는 작업들은 동시에 수행이 가능하다.
// 그렇기 때문에 모든 작업을 완료하기 위한 최소 시간은 가장 오래걸리는 놈의 시간이다.

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int[] inDegree, times, timesSum;
    static List<Integer>[] list;
    static ArrayDeque<Integer> Q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        inDegree = new int[N+1];
        times = new int[N+1];
        timesSum = new int[N+1];
        list = new List[N+1];
        for (int i = 1; i <= N; i++) list[i] = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            timesSum[i] = times[i] = Integer.parseInt(st.nextToken()); // 지금 일이 걸리는 시간을 저장
            int m = Integer.parseInt(st.nextToken()); // 선행 작업의 개수

            while (m-- > 0) {
                int priority = Integer.parseInt(st.nextToken()); // 선행 작업
                list[priority].add(i); // 지금 일의 리스트에 저장
                inDegree[i]++; // 선행 작업의 진입차수 증가
            }
        }

        for (int i = 1; i <= N; i++) // 진입차수가 0인 애들 큐에 삽입
            if (inDegree[i] == 0)
                Q.addLast(i);

        while (!Q.isEmpty()) {
            int now = Q.removeFirst();

            for (int next : list[now]) {
                inDegree[next]--;
                timesSum[next] = Math.max(timesSum[next], timesSum[now] + times[next]);
                if (inDegree[next] == 0) Q.addLast(next);
            }
        }

        int max = 0;
        for (int i = 1; i < N + 1; i++) {
            max = Math.max(max, timesSum[i]);
        }

        System.out.print(max);
    }

}
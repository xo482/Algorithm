import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M;
    static int[] arr;
    static PriorityQueue<int[]> Q = new PriorityQueue<>(new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            if (o1[1] == o2[1]) return o1[0] - o2[0];
            return o1[1] - o2[1];
        }
    });

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            Q.add(new int[]{i, arr[i]});
        }

        M = Integer.parseInt(br.readLine());
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int request = Integer.parseInt(st.nextToken());
            if (request == 1) {
                int i = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                arr[i] = v;
                Q.add(new int[]{i, v});
            }
            if (request == 2) {
                int[] now;
                while (true) {
                    now = Q.peek();
                    if (arr[now[0]] == now[1]) break;
                    Q.poll();
                }
                sb.append(now[0]).append("\n");
            }
        }
        System.out.println(sb);
    }
    //우선순위로 나열하면 값을 교체할때 순회해야하고
    // 배열 그대로 쓰면 최솟값 찾을 때 순회해야함.
    // 둘 다 써서 두번 체크
}

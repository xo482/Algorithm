import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int T;
    static int N; // 문서의 개수
    static int M; // 찾는 인덱스
    static ArrayDeque<int[]> Q;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            Q = new ArrayDeque<>();
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++)
                Q.addLast(new int[]{i, Integer.parseInt(st.nextToken())});

            int cnt = 0;
            while (!Q.isEmpty()) {
                boolean flag = false;
                int now = Q.getFirst()[1]; // 지금 큐 맨 앞에 있는 요소의 우선순위
                for (int[] ints : Q) {
                    if (now < ints[1]) {
                        flag = true; // 우선순위가 높은게 뒤에 있으면
                        break;
                    }
                }

                // 우선순위가 높은게 뒤에 있으면
                if (flag) {
                    Q.addLast(Q.removeFirst());
                } else {
                    cnt++;
                    if (Q.removeFirst()[0] == M) {
                        sb.append(cnt).append("\n");
                        break;
                    }
                }
            }
        }

        System.out.print(sb);
    }
}
import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int T, K, M, P;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            P = Integer.parseInt(st.nextToken());

            int[] inDegree = new int[M + 1];
            ArrayDeque<Integer> Q = new ArrayDeque<>();
            List<Integer>[] list = new List[M + 1];
            for (int i = 1; i < M + 1; i++) list[i] = new ArrayList<>();
            List<Integer>[] orderList = new List[M + 1];
            for (int i = 1; i < M + 1; i++) orderList[i] = new ArrayList<>();
            int[] orders = new int[M + 1];

            while (P-- > 0) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                list[a].add(b);
                orderList[b].add(a);
                inDegree[b]++;
            }

            for (int i = 1; i < M + 1; i++){
                if (inDegree[i] == 0) {
                    Q.add(i);
                    orders[i] = 1;
                }
            }

            while (!Q.isEmpty()) {
                int now = Q.removeFirst();

                for (int nxt : list[now]) {
                    if (--inDegree[nxt] == 0) {
                        Q.add(nxt);

                        int max = -1;
                        int check = 0;
                        for (int pre : orderList[nxt]) max = Math.max(max, orders[pre]);
                        for (int pre : orderList[nxt])
                            if (orders[pre] == max)
                                check++;

                        if (check >= 2) max++;
                        orders[nxt] = max;
                    }
                }
            }

            sb.append(K).append(" ").append(orders[M]).append("\n");
        }
        System.out.print(sb);
    }
}
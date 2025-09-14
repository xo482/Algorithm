import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static int[] cranes, box;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        cranes = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) cranes[i] = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(br.readLine());
        box = new int[M];
        visited = new boolean[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) box[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(cranes);
        for (int i = 0; i < N/2; i++) {
            int temp = cranes[i];
            cranes[i] = cranes[N - 1 - i];
            cranes[N - 1 - i] = temp;
        }
        Arrays.sort(box);
        for (int i = 0; i < M/2; i++) {
            int temp = box[i];
            box[i] = box[M - 1 - i];
            box[M - 1 - i] = temp;
        }

        if (cranes[0] < box[0]) {
            System.out.println(-1);
            return;
        }

        for (int i = 0; i < N; i++) {
            boolean flag = false;
            int can = cranes[i];
            for (int j = 0; j < M; j++) {
                if (can >= box[j]) {
                    cranes[i] = j;
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                cranes[i] = M;
            }
        }

        int time = 0;
        int totalCnt = 0;
        while (true) {
            if (totalCnt == M) break;

            for (int i = 0; i < N; i++) {
                int idx = cranes[i];
                while (true) {
                    if (idx >= M) break;
                    if (visited[idx]) {
                        idx += 1;
                        continue;
                    }
                    visited[idx] = true;
                    totalCnt += 1;
                    cranes[i] = idx + 1;
                    break;
                }
            }

            time += 1;
        }
        System.out.println(time);
    }
}




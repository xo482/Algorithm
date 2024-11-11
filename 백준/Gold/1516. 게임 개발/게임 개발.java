import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N;
    static int[] inDegree, times, sumList;
    static List<Integer>[] list;
    static ArrayDeque<Integer> Q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        inDegree = new int[N + 1];
        times = new int[N + 1];
        sumList = new int[N + 1];
        list = new List[N + 1];
        for (int i = 1; i < N + 1; i++) list[i] = new ArrayList<>();
        
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            times[i] = Integer.parseInt(st.nextToken());
            while (true) {
                int pre = Integer.parseInt(st.nextToken());
                if (pre == -1) break;
                list[pre].add(i);
                inDegree[i]++;
            }
        }

        for (int i = 1; i < N + 1; i++)
            if (inDegree[i] == 0) {
                sumList[i] = times[i];
                Q.add(i);
            }

        while (!Q.isEmpty()) {
            Integer now = Q.removeFirst();

            for (Integer nxt : list[now]) {
                sumList[nxt] = Math.max(sumList[nxt], sumList[now] + times[nxt]);
                if (--inDegree[nxt] == 0) Q.add(nxt);
            }
        }

        for (int i = 1; i < N + 1; i++) sb.append(sumList[i]).append("\n");
        System.out.print(sb.toString());
    }
}
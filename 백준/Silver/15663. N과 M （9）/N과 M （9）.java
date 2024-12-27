import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static int[] snapShot;
    static boolean[] visited;
    static List<Integer> list = new ArrayList<>();
    static List<String> answer = new ArrayList<>();
    static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        snapShot = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            list.add(num);
        }
        Collections.sort(list);

        visited = new boolean[list.size()];
        tracking(0);

        for (String s : answer) {
            stringBuilder.append(s).append("\n");
        }
        System.out.println(stringBuilder);
    }

    static void tracking(int depth) {
        if (depth == M) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < M; i++) sb.append(snapShot[i]).append(" ");
            if (!answer.contains(sb.toString())) answer.add(sb.toString());
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            if (visited[i]) continue;

            visited[i] = true;
            snapShot[depth] = list.get(i);
            tracking(depth + 1);
            visited[i] = false;
        }
    }
}
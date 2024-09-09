import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int k;
    static int[] list;
    static int[] answer = new int[6];

    public static void main(String[] args) throws IOException {

        while (true) {
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            if (k == 0) break;

            list = new int[k];
            for (int i = 0; i < k; i++) list[i] = Integer.parseInt(st.nextToken());

            dfs(0,0);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int index, int depth) {
        if (depth == 6) {
            printStr();
            return;
        }
        for (int i = index; i < k; i++) {
            answer[depth] = list[i];
            dfs(i + 1, depth + 1);
        }
    }
    private static void printStr() {
        for (int i : answer) {
            sb.append(i).append(" ");
        }
        sb.append("\n");
    }
}
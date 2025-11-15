import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int INF = 987654321;
    static int num, size;
    static boolean[] visited;
    static boolean flag;
    static String str;

    public static void main(String[] args) throws Exception {


        while (true) {
            str = br.readLine();
            if (str == null || str.isEmpty()) break;
            num = Integer.parseInt(str);

            if (num >= INF) {
                sb.append(0).append('\n');
                continue;
            }

            size = str.length();
            if (str.charAt(0) == '9') size++;

            flag = false;
            visited = new boolean[10];
            tracking(0, 0);
        }

        System.out.println(sb);
    }

    private static void tracking(int n, int depth) {
        if (depth == size) {
            if (num < n) {
                sb.append(n).append('\n');
                flag = true;
            }
            return;
        }

        for (int i = 1; i <= 9; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            tracking(n + i * (int) Math.pow(10, size - depth - 1), depth + 1);
            if (flag) break;
            visited[i] = false;
        }
    }
}
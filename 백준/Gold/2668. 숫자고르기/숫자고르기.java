import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[] arr;
    static boolean[] visited;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];
        arr = new int[N + 1];
        for (int i = 1; i < N + 1; i++) arr[i] = Integer.parseInt(br.readLine());

        for (int i = 1; i < N + 1; i++) {
            visited[i] = true;
            dfs(i,i);
            visited[i] = false;
        }

        sb.append(list.size()).append("\n");
        for (int i : list) sb.append(i).append("\n");
        
        System.out.print(sb.toString());
    }

    static void dfs(int n, int target) {

        if (arr[n] == target) list.add(target);
        if (visited[arr[n]]) return;

        visited[arr[n]] = true;
        dfs(arr[n], target);
        visited[arr[n]] = false;
    }
}

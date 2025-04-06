import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M, K;
    static int[] arr, need;
    static boolean[] visited;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        need = new int[N];
        arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = i;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) need[i] = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;

            int fa = find(a);
            int fb = find(b);

            if (need[fa] < need[fb]) arr[fb] = fa;
            else arr[fa] = fb;
        }

        int sum = 0;
        for (int i = 0; i < N; i++) {
            int fi = find(i);
            if (visited[fi]) continue;

            sum += need[fi];
            visited[fi] = true;

            if (sum > K){
                System.out.print("Oh no");
                return;
            }
        }
        System.out.print(sum);
    }

    static int find(int a) {
        if (arr[a] == a) return a;
        return arr[a] = find(arr[a]);
    }
}
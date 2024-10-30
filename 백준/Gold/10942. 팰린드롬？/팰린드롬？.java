import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static Set<String> set = new HashSet<>();
    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());


        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                int s = i;
                int e = j;

                boolean flag = false;
                while (s <= e){
                    if (arr[s] != arr[e]) { flag = true; break; }
                    s++; e--;
                }
                if (!flag) set.add((i+1)+" "+(j+1));
            }
        }


        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            if (set.contains(br.readLine())) sb.append(1);
            else sb.append(0);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int M;
    static boolean[] list;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new boolean[M+1];
        list[1] = true;

        for (int i = 2; i <= M; i++)
            if (!list[i])
                for (int j = 2 * i; j <= M; j += i)
                    list[j] = true;


        for (int i = N; i <= M; i++)
            if (!list[i])
                sb.append(i).append("\n");
        System.out.print(sb);
    }
}
import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, cnt, now;
    static long answer = 1;
    static int[] board;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        board = new int[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            board[Integer.parseInt(st.nextToken()) - 1] = i;
        }


        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            cnt = 0;
            now = i;

            while (!visited[now]) {
                visited[now] = true;
                now = board[now];
                cnt++;
            }

            answer = answer * cnt / gcd((int)answer, cnt);
        }
        System.out.println(answer);
    }
    
    static int gcd(int a, int b){
        while(b != 0){
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}

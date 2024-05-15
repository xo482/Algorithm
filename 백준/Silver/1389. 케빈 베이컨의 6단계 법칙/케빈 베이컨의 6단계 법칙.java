import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int M;
    static ArrayDeque<int[]> Q;

    public static void main(String[] args) throws IOException {

        Q = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] list = new int[N][N];
        for (int i = 0; i < N; i++) 
            for (int j = 0; j < N; j++) 
                list[i][j] = 100;
        
        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            list[r][c] = 1;
            list[c][r] = 1;
        }
        
        for (int k = 0; k < N; k++) 
            for (int i = 0; i < N; i++) 
                for (int j = 0; j < N; j++) 
                    if (list[i][j] > list[i][k] + list[k][j]) list[i][j] = list[i][k] + list[k][j];
        
        int ans = 0;
        int x = 10000;
        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = 0; j < N; j++) {
                if (i==j) continue;
                sum += list[i][j];
            }
            
            if(sum < x) {
                x = sum;
                ans = i;
            }
        }
        System.out.print(ans + 1);
    }
}
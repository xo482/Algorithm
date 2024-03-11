import java.util.*;
import java.io.*;

public class Main {

    public static void solution(int[][] arr) {
        for(int k = 0; k < arr.length; k++) {
            for(int i = 0; i < arr.length; i++) {
                for(int j = 0; j < arr.length; j++) {
                    if(k == i || k == j) continue;
                    arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        for(int i = 0; i < arr.length; i++) {
            Arrays.fill(arr[i], 10000000);
            arr[i][i] = 0;
        }
        for(int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());
            arr[a][b] = Math.min(arr[a][b], c);
        }

        StringBuilder sb = new StringBuilder();
        solution(arr);
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                if(arr[i][j] == 10000000) sb.append(0).append(" ");
                else sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int[][] arr = new int[9][9];
        int r=0, c=0;

        for(int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] > arr[r][c]) {
                    r = i;
                    c = j;
                }
            }
        }

        sb.append(arr[r][c]).append("\n").append(r+1).append(" ").append(c+1);
        System.out.print(sb);

    }
}

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][3];
        int[][] min = new int[N][3];
//        int[] max = new int[3];
//        int[] max = new int[3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            min[i][0] = arr[i][0] = Integer.parseInt(st.nextToken());
            min[i][1] = arr[i][1] = Integer.parseInt(st.nextToken());
            min[i][2] = arr[i][2] = Integer.parseInt(st.nextToken());
        }

        for (int i = N-2; i >= 0; i--) {
            arr[i][0] += Math.max(arr[i + 1][0], arr[i + 1][1]);
            arr[i][1] += Math.max(arr[i + 1][0], Math.max(arr[i + 1][1], arr[i + 1][2]));
            arr[i][2] += Math.max(arr[i + 1][1], arr[i + 1][2]);
        }

        for (int i = N-2; i >= 0; i--) {
            min[i][0] += Math.min(min[i + 1][0], min[i + 1][1]);
            min[i][1] += Math.min(min[i + 1][0], Math.min(min[i + 1][1], min[i + 1][2]));
            min[i][2] += Math.min(min[i + 1][1], min[i + 1][2]);
        }

        System.out.print(Math.max(arr[0][0], Math.max(arr[0][1], arr[0][2])) + " " +
                Math.min(min[0][0], Math.min(min[0][1], min[0][2])));
    }
}
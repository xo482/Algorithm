import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[][] arr;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        arr = new int[N+2][10];
        for (int i = 0; i < 10; i++) arr[1][i] = 1;

        for (int i = 2; i < N+2; i++) {

            for (int j = 0; j < 10; j++) {

                int sum = 0;
                for (int k = j; k < 10; k++) {
                    sum += arr[i-1][k];
                }
                arr[i][j] = sum%10007;
            }
        }
        System.out.println(arr[N+1][0]);

        // for (int i = 0; i < 10; i++) {
        //     for (int j = 0; j < 10; j++) {
        //         System.out.print(arr[i][j] + " ");
        //     }
        //     System.out.println();
        // }
    }
}
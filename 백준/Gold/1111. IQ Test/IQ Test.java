import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        if (N == 1) {
            System.out.println("A");
            return;
        }

        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        if (N == 2) {
            if (arr[0] != arr[1]) {
                System.out.println("A");
                return;
            }
            else {
                System.out.println(arr[0]);
                return;
            }
        }

        int a, b;
        int x = arr[0] - arr[1]; // a의 계수
        int q = arr[1] - arr[2]; // 몫


        if (x == 0) {
            a = 1;
            b = 0;
        } else {
            a = q / x;
            b = arr[1] - (arr[0] * a);
        }




        // 전부 유효한지 검사
        boolean flag = false;
        for (int i = 0; i <N-1; i++) {
            if (arr[i+1] != arr[i]*a + b) {
                flag = true;
                break;
            }
        }

        if (flag) {
            System.out.println("B");
            return;
        }

        System.out.println(arr[N-1]*a+b);
    }
}
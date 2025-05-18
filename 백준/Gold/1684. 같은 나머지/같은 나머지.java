import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N - 1];
        st = new StringTokenizer(br.readLine());
        int temp = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N-1; i++) {
            int c = Integer.parseInt(st.nextToken());
            arr[i] = Math.abs(temp - c);
            temp = c;
        }
        Arrays.sort(arr);


        int ans = arr[0];
        for (int i = 1; i < N - 1; i++) {
            ans = gcd(ans, arr[i]);
        }
        System.out.println(ans);
    }

    static int gcd(int a, int b) {
        if (a < b){
            int temp = a;
            a = b;
            b = temp;
        }

        if (b==0) return a;
        return gcd(b, a%b);
    }
}
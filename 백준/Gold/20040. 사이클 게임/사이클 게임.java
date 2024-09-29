import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m;
    static int[] arr;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = i;

        for (int cnt = 1; cnt < m+1; cnt++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int af = findParent(a);
            int bf = findParent(b);

            if (af == bf) {
                answer = cnt;
                break;
            }

            arr[af] = bf;
        }
        System.out.println(answer);
    }

    static int findParent(int x) {
        if (x == arr[x]) return x;
        return arr[x] = findParent(arr[x]);
    }
}
import java.io.*;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, answer;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        answer = Integer.parseInt(br.readLine());

        int idx1 = 0;
        int idx2 = n-1;
        int cnt = 0;

        for (; idx2 > 0; idx2--) {

            if (idx1 == idx2) break;

            if (arr[idx1] + arr[idx2] == answer) cnt++;
            if (arr[idx1] + arr[idx2] < answer) {
                idx1++; idx2++;
            }
        }

        System.out.print(cnt);
    }
}
import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, B, W;
    static char[] arr;
    static int ans = 0;


    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        arr = br.readLine().toCharArray();

        int s = 0, e = 0;
        int len = 0, bc = 0, wc = 0;
        while (s <= e+1 && e < N) {
            
            if (s > e) {
                e = s;
                len = 0;
                bc = 0;
                wc = 0;
                continue;
            }
            
            if (arr[e] == 'W') {
                len++;
                wc++;
                e++;
            }
            else if (bc < B) {
                len++;
                bc++;
                e++;
            }
            else if (arr[s] == 'W'){
                len--;
                wc--;
                s++;
            }
            else {
                len--;
                bc--;
                s++;
            }

            if (wc >= W) ans = Math.max(ans, len);
        }
        System.out.println(ans);
    }
}
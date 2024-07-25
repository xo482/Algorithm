import java.io.*;
import java.util.*;

public class Main{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int A, B, C, M;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int total = 0, cnt = 0;

        for (int i = 0; i < 24; i++) {
            if (total + A > M) total = (total < C)?0:total-C;
            else {
                total += A;
                cnt++;
            }
        }

        System.out.print(cnt*B);
    }
}
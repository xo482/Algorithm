import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int cnt = 0;

        while (N > 1) {
            int oneBlock = (int) Math.pow(2, N-1);
            int pass = 0;
            if (r < oneBlock && c < oneBlock) pass = 0;
            if (r < oneBlock && c >= oneBlock) pass = 1;
            if (r >= oneBlock && c < oneBlock) pass = 2;
            if (r >= oneBlock && c >= oneBlock) pass = 3;
            
            cnt += ((int) Math.pow(2, 2*N - 2)) * pass;
            r = r % oneBlock;
            c = c % oneBlock;
            N--;
        }
        

        if (r % 2 == 0) {
            if (c % 2 == 1) cnt += 1;
        } else {
            if (c % 2 == 1) cnt += 3;
            else cnt += 2;
        }

        System.out.print(cnt);
    }
}
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0, i = 0;
        boolean x = true;

        for (i = N/5; i >= 0; i--) {
            if ((N - (5 * i)) % 3 == 0) {
                x = false;
                break;
            }
        }

        if (x) {
            System.out.println(-1);
        } else {
            cnt += i;
            cnt += (N - (5 * i)) / 3;
            System.out.println(cnt);
        }



    }
}
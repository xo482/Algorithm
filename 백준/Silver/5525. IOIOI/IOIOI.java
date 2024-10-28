import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static char[] filter, arr;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        arr = br.readLine().toCharArray();

        filter = new char[2 * N + 1];
        for (int i = 0; i < 2*N+1; i++) {
            if (i%2 == 0) filter[i] = 'I';
            else filter[i] = 'O';
        }

        int cnt = 0;
        for (int i = 0; i <= M - (2 * N + 1); i++) {

            boolean flag = false;

            for (int j = 0; j < 2 * N + 1; j++) {
                if (filter[j] != arr[i+j]){
                    flag = true; break;
                }
            }

            if (!flag) cnt++;
        }
        System.out.println(cnt);
    }
}
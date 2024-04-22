import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int K = Integer.parseInt(str[1]);
        int[] arr = new int[N];
        int index = N - 1;
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        while (index >= 0) {

            cnt += (K / arr[index]);
            K %= arr[index];

            index--;
        }

        System.out.println(cnt);
    }
}

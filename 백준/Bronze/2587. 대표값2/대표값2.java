import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = 5;
        int[] list = new int[N];
        int sum = 0;

        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(br.readLine());
            sum+= list[i];
        }

        // 평균
        System.out.println(sum/5);

        Arrays.sort(list);
        System.out.println(list[2]);
    }
}
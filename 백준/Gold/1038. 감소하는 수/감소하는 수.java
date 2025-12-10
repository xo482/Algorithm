import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static List<Long> list = new ArrayList<>();
    static int[] arr = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        if (N >= 1023) {System.out.println(-1); return;}

        for (int i = 1; i < 1024; i++) {
            long sum = 0;
            int pos = 0;
            for (int j = 0; j < 10; j++) {
                if ((i & (1 << j)) > 0) {
                    sum += arr[j] * (long)Math.pow(10, pos++);
                }
            }
            list.add(sum);
        }

        Collections.sort(list);
        System.out.println(list.get(N));
    }
}
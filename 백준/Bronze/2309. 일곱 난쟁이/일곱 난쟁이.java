import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] list = new int[9];
    static int now;
    static int sum;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        for (int i = 0; i < 9; i++) {
            now = Integer.parseInt(br.readLine());
            list[i] = now;
            sum += now;
        }
        Arrays.sort(list);

        for (int i = 0; i < 9; i++) {
            for (int j = i+1; j < 9; j++) {

                if (sum - (list[i] + list[j]) == 100) {
                    for (int k = 0; k < 9; k++) {
                        if (k == i || k == j) continue;
                        sb.append(list[k]).append("\n");
                    }
                    System.out.print(sb);
                    return;
                }
            }
        }
    }
}
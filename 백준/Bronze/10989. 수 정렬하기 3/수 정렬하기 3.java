import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] list = new int[N];

        while (N-- > 0) {
            list[N] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(list);

        for (int i : list) {
            sb.append(i).append("\n");
        }
        System.out.print(sb);
    }
}

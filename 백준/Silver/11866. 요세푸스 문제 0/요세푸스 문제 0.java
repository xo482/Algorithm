import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder("<");
        int N = Integer.parseInt(s[0]);
        int K = Integer.parseInt(s[1]);
        int index = K-1;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) list.add(i + 1);

        while (!list.isEmpty()) {
            index %= list.size();
            if (list.size() == 1) sb.append(list.remove(index)).append(">");
            else sb.append(list.remove(index)).append(", ");
            index += (K-1);
        }

        System.out.print(sb);
    }
}
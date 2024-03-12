import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> S = new ArrayList<>();
        int low;
        int high;

        for (int i = 0; i < len; i++) {
            S.add(Integer.parseInt(st.nextToken()));
        }

        Integer n = Integer.parseInt(br.readLine());

        if (S.contains(n)) {
            System.out.println("0");
            return;
        } else {
            S.add(n);
        }
        Collections.sort(S);

        int index = S.indexOf(n);

        if (index == 0) {
            low = 0;
            high = S.get(index + 1);
        } else {
            low = S.get(index - 1);
            high = S.get(index + 1);
        }

        int result = (n - low - 1) * (high - n - 1) + (high - n - 1) + (n - low - 1);
        System.out.println(result);

    }
}
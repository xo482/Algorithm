import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static List<String> l1 = new ArrayList<>();
    static List<String> l2 = new ArrayList<>();
    static int total = 0;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) l1.add(br.readLine());
        for (int i = 0; i < N; i++) l2.add(br.readLine());

        int p1 = 0;
        int p2 = 0;
        int cnt = 0;

        while (p1 < N) {
            if (l1.get(p1).equals(l2.get(p2))) {

                if (p1 > p2 - cnt) {
                    total++;
                    cnt--;
                }



                p1++;
                p2 = 0;
                continue;
            }

            if (p1 <= p2 - cnt){
                cnt++;
            }

            p2++;
        }

        System.out.println(total);
    }
}


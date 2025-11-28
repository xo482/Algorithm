import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String S, P;
    static int ans = 1;

    public static void main(String[] args) throws Exception {
        S = br.readLine();
        P = br.readLine();
        int len = P.length();
        int p1 = 0, p2 = 1;

        while (p2 <= len) {
            String sub = P.substring(p1, p2);
            if (S.contains(sub)) {
                p2++;
                continue;
            }
            
            p1 = p2 - 1;
            ans++;
        }
        System.out.println(ans);
    }
}
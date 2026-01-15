import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int A,B,C,D,E;

    public static void main(String[] args) throws Exception {
        A = Integer.parseInt(br.readLine());
        B = Integer.parseInt(br.readLine());
        C = Integer.parseInt(br.readLine());
        D = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());

        int ans = 0;
        if (A < 0) ans -= A * C;
        if (A <= 0) ans += D;

        if (A > 0) B = B - A;
        ans += B * E;

        System.out.println(ans);
    }
}
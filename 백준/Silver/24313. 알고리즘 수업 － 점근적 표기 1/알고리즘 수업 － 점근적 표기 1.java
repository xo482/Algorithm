import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int a1 = Integer.parseInt(s[0]);
        int a0 = Integer.parseInt(s[1]);
        int c = Integer.parseInt(br.readLine());
        int n0 = Integer.parseInt(br.readLine());

        // a1, c
        if (a1 > c || (a1 == c && a0 > 0)) {
            System.out.print("0");
            return;
        }

        // a0, n0
        if ((a1 * n0 + a0) > (c * n0)) {
            System.out.print("0");
            return;
        }

        System.out.print("1");
    }
}
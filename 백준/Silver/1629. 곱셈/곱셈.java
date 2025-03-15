import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int A,B,C;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        System.out.print(method(A, B));

//
//        7^8 % 5 = (7^4%5 * 7^4%5) % 5
//        7^9 % 5 =  (7^8%5 * 7%5)%5 =  ((7^4%5 + 7^4%5) % 5 * 7%5)%5
//
//            7^9 = 7^8 * 7
    }

    private static long method(int a, int b) {
        if (b == 1) return a % C;

        long temp = method(a,b/2);
        if (b % 2 == 0) return temp * temp % C;
        return (temp * temp % C * a % C) % C;
    }
}
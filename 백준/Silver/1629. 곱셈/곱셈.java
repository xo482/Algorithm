import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int A;
    static int B;
    static int C;
    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        System.out.print(method(A, B));
    }

    private static long method(int a, int b) {
        if (b == 1) return a % C;

        long answer = method(a, b / 2);
        if (b % 2 == 0) return answer * answer % C;
        return (answer * answer % C) * a % C;
    }
}

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, cnt = 0;
    static int a, b, temp;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        a = N / 10;
        b = N % 10;

        while (true){
            temp = b;
            b = (a + b)%10;
            a = temp;
            cnt++;
            if (N == a*10+b) break;
        }
        System.out.println(cnt);
    }
}
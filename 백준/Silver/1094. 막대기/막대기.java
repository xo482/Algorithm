import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        int cnt = 0;
        int i=0;

        while (X > 0) {
            int now = 0;
            i = 0;

            while (now <= X) {
                now = (int) Math.pow(2, ++i);
            }

            now /= 2;
            X -= now;
            cnt++;
        }

        System.out.println(cnt);
    }
}
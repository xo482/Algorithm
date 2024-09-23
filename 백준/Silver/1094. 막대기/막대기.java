import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int X = 64;
    static int sum = 64;
    static int answer;
    static int cnt = 1;

    public static void main(String[] args) throws IOException {
        answer = Integer.parseInt(br.readLine());

        while (X > 0) {
            if(answer == sum) break;
            X = X / 2;
            cnt++;
            if (answer <= sum - X) {
                sum = sum - X;
                cnt--;
            }
        }

        System.out.println(cnt);
    }
}
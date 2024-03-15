import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int A_len = s[0].length();
        char[] A = new char[A_len];
        for (int i = 0; i < A_len; i++) A[i] = s[0].charAt(i);

        int B_len = s[1].length();
        char[] B = new char[B_len];
        for (int i = 0; i < B_len; i++) B[i] = s[1].charAt(i);

        int min = 51;
        for (int i = 0; i <= B_len-A_len; i++) {
            int cnt = 0;
            for (int j = 0; j < A_len; j++) {
                if (A[j] != B[i+j]) cnt++;
            }
            if (cnt < min) min = cnt;
        }

        System.out.println(min);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int n;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            int a = 0;
            int b = 0;
            String answer = "";
            String[] strings = br.readLine().split("");

            for (String s : strings) {
                if (s.equals("(")) a++;
                else b++;

                if (a < b) {
                    answer = "NO";
                    break;
                }
            }

            if (answer.equals("")) {
                if (a==b) answer = "YES";
                else answer = "NO";
            }

            sb.append(answer).append("\n");
        }

        System.out.print(sb);
    }
}

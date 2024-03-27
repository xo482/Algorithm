import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int plus = 0, minus = 0;
        StringBuilder sb1 = new StringBuilder(); // +
        StringBuilder sb2 = new StringBuilder(); // -
        boolean flag = false;

        for(int i = 0; i < str.length(); i++) {

            char now = str.charAt(i);

            if (now == '-') {
                flag = true;
            }
            if (now == '-' || now == '+') {
                if (flag) sb2.append(" ");
                else sb1.append(" ");
            } else {
                if (flag) sb2.append(now);
                else sb1.append(now);
            }

        }

        String[] s1 = sb1.toString().split(" ");
        for(String s : s1) {
            plus += Integer.parseInt(s);
        }

        String[] s2 = sb2.toString().split(" ");
        for(String s : s2) {
            if (s.equals("")) continue;
            minus += Integer.parseInt(s);
        }

        System.out.print(plus - minus);
    }
}

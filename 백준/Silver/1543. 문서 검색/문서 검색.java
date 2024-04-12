import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String sub = br.readLine();
        int N = str.length();
        int M = sub.length();
        int cnt = 0;
        boolean flag;

        for (int i = 0; i < N-M+1; i++) {
            flag = true;
            for (int j = i; j < i+M; j++) {
                if (str.charAt(j) != sub.charAt(j - i)) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                i+=(M-1);
                cnt++;
            }
        }

        System.out.print(cnt);
    }
}
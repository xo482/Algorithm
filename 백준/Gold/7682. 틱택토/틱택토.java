import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {

        while (true) {
            String s = br.readLine();
            if (s.equals("end")) break;

            int xCnt = 0;
            int oCnt = 0;
            char[] chars = s.toCharArray();
            for (char c : chars) {
                if (c == 'X') xCnt++;
                if (c == 'O') oCnt++;
            }

            // 가능한 개수가 아닐 경우
            if (xCnt != oCnt + 1 && xCnt != oCnt) {
                sb.append("invalid\n");
                continue;
            }
            
            boolean oCheck = check('O', chars);
            boolean xCheck = check('X', chars);

            // 둘 다 빙고인 경우
            if (xCheck && oCheck) {
                sb.append("invalid\n");
                continue;
            }

            // 둘 다 빙고가 아닌데 9개가 아닐 경우
            if (!xCheck && !oCheck && oCnt + xCnt != 9) {
                sb.append("invalid\n");
                continue;
            }

            // x 빙고인데 xC == oC + 1가 아닐 경우
            if (xCheck && xCnt != oCnt + 1) {
                sb.append("invalid\n");
                continue;
            }

            // o 빙고인데 xC == oC가 아닐 경우
            if (oCheck && xCnt != oCnt) {
                sb.append("invalid\n");
                continue;
            }

            // 문제 없이 빙고가 없는 경우, o 빙고인데 xC == oC인 경우, x 빙고인데 xC == oC + 1인 경우
            sb.append("valid\n");
        }

        System.out.println(sb);
    }

    static boolean check(char c, char[] chars) {
        for (int i = 0; i < 3; i++)
            if (chars[i] == c && chars[i] == chars[i+3] && chars[i] == chars[i+6])
                return true;

        for (int i = 0; i < 9; i+=3)
            if (chars[i] == c && chars[i] == chars[i+1] && chars[i] == chars[i+2])
                return true;

        if (chars[0] == c && chars[0] == chars[4] && chars[4] == chars[8]) return true;
        if (chars[6] == c && chars[6] == chars[4] && chars[4] == chars[2]) return true;

        return false;
    }
}
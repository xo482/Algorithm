import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int L, A, B, C, D;

    public static void main(String[] args) throws Exception {
        L = Integer.parseInt(br.readLine());
        A = Integer.parseInt(br.readLine());
        B = Integer.parseInt(br.readLine());
        C = Integer.parseInt(br.readLine());
        D = Integer.parseInt(br.readLine());

        int daysKorean = (A + C - 1) / C; // 국어 최소 일수
        int daysMath = (B + D - 1) / D;   // 수학 최소 일수

        int studyDays = Math.max(daysKorean, daysMath);

        System.out.println(L - studyDays);
    }
}
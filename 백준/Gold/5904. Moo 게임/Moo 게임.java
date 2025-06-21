import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        int totalSize = 3;
        int k = 0;

        while (true) {
            if (totalSize > N) break;
            totalSize = totalSize * 2 + k + 4;
            k++;
        }

        System.out.println(go(k, totalSize));
    }

    private static String go(int k, int totalSize) {
        if (k == 0) {
            if (N == 1) return "m";
            return "o";
        }

        int midSize = k + 3;
        int sideSize = (totalSize - midSize) / 2;
//        System.out.println("totalSize = " + totalSize);
//        System.out.println("sideSize = " + sideSize);
//        System.out.println("midSize = " + midSize);

        if (N == sideSize + 1){
            return "m";
        }
        if (sideSize + 1 < N && N < sideSize + midSize + 1) {
            return "o";
        }

        if (N >= sideSize + midSize + 1) {
            N -= sideSize + midSize;
        }
        return go(k - 1, sideSize);
    }
}
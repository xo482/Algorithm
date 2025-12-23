import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] numbers = new int[10];

    public static void main(String[] args) throws Exception {
        char[] chars = br.readLine().toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int num = chars[i] - '0';
            if (num == 6) num = 9;
            numbers[num]++;
        }
        
        if (numbers[9] % 2 == 1) numbers[9]++;
        numbers[9] /= 2;

        int max = 0;
        for (int i = 0; i < 10; i++) max = Math.max(max, numbers[i]);
        System.out.println(max);
    }
}
import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static Map<Character, Integer> map = new HashMap<>();
    static Map<Integer, String> m100 = new HashMap<>();
    static Map<Integer, String> m10 = new HashMap<>();
    static Map<Integer, String> m1 = new HashMap<>();

    public static void main(String[] args) throws IOException {

        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        m1.put(0, "");
        m1.put(1, "I");
        m1.put(2, "II");
        m1.put(3, "III");
        m1.put(4, "IV");
        m1.put(5, "V");
        m1.put(6, "VI");
        m1.put(7, "VII");
        m1.put(8, "VIII");
        m1.put(9, "IX");

        m10.put(0, "");
        m10.put(1, "X");
        m10.put(2, "XX");
        m10.put(3, "XXX");
        m10.put(4, "XL");
        m10.put(5, "L");
        m10.put(6, "LX");
        m10.put(7, "LXX");
        m10.put(8, "LXXX");
        m10.put(9, "XC");

        m100.put(0, "");
        m100.put(1, "C");
        m100.put(2, "CC");
        m100.put(3, "CCC");
        m100.put(4, "CD");
        m100.put(5, "D");
        m100.put(6, "DC");
        m100.put(7, "DCC");
        m100.put(8, "DCCC");
        m100.put(9, "CM");

        int num1 = romaToNum(br.readLine());
        int num2 = romaToNum(br.readLine());
        sb.append(num1+num2).append("\n");
        sb.append(numToRoma(num1 + num2));

        System.out.println(sb);
    }

    private static String numToRoma(int num) {
        StringBuilder sb = new StringBuilder();

        sb.append("M".repeat(num / 1000));
        num -= num / 1000 * 1000;

        sb.append(m100.get(num / 100));
        num -= num / 100 * 100;

        sb.append(m10.get(num / 10));
        num -= num / 10 * 10;

        sb.append(m1.get(num));

        return sb.toString();
    }

    static int romaToNum(String str) {
        int num = 0;
        for (int i = 0; i < str.length(); i++) {
            if (i < str.length()-1 && map.get(str.charAt(i)) < map.get(str.charAt(i+1))) {
                num += map.get(str.charAt(i+1)) - map.get(str.charAt(i));
                i++;
                continue;
            }

            num += map.get(str.charAt(i));
        }
        return num;
    }
}
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Character> stack = new ArrayList<>();

        char[] arr = br.readLine().toCharArray();
        for (char c : arr) {
            int len = stack.size();
            if (len < 3) {
                stack.add(c);
                continue;
            }

            if (c == 'P' && stack.get(len - 1) == 'A' && stack.get(len - 2) == 'P' && stack.get(len - 3) == 'P') {
                stack.remove(len - 1);
                stack.remove(len - 2);
                stack.remove(len - 3);
                stack.add('P');
                continue;
            }

            stack.add(c);
        }

        if (stack.size() == 1 && stack.get(0) == 'P') System.out.println("PPAP");
        else System.out.println("NP");
    }
}

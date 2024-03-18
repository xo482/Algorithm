import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i = Integer.parseInt(br.readLine());
        String str;
        List<Integer> list = new ArrayList<>();

        for (int j = 666; j <= 2666799; j++) {
            str = String.valueOf(j);
            if (str.contains("666")) list.add(j);
        }

        System.out.print(list.get(i-1));
    }
}
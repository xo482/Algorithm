import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int A,P;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        list.add(A);
        while (true) {
            A = apMethod();
            if (list.contains(A)) break;
            list.add(A);
        }

        System.out.println(list.indexOf(A));
    }

    private static int apMethod() {
        double sum = 0;
        char[] arr = String.valueOf(A).toCharArray();
        for (char c : arr)
            sum += Math.pow(c-'0', P);

        return (int) sum;
    }
}


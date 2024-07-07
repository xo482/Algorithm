import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        int time = 0;

        for (int i = 0; i < N; i++) list.add(Integer.parseInt(st.nextToken()));
        Collections.sort(list);
        for (int i = N; i >= 1; i--) time += (list.remove(0) * i);
        System.out.print(time);
    }
}
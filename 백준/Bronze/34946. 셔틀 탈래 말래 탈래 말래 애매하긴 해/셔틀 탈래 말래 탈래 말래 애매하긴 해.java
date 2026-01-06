import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int A,B,C, D;
    static boolean shuttle = false, walk = false;
    static String answer;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        if (A+B <= D) shuttle = true;
        if (C <= D) walk = true;
        
        if (shuttle && walk) answer = "~.~";
        else if (shuttle) answer = "Shuttle";
        else if (walk) answer = "Walk";
        else answer = "T.T";
        
        System.out.println(answer);
    }
}
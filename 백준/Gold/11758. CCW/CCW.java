



import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int P1_x = Integer.parseInt(st.nextToken());
        int P1_y = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int P2_x = Integer.parseInt(st.nextToken());
        int P2_y = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int P3_x = Integer.parseInt(st.nextToken());
        int P3_y = Integer.parseInt(st.nextToken());
       
        int a_x = P2_x - P1_x;
        int a_y = P2_y - P1_y;
        int b_x = P3_x - P2_x;
        int b_y = P3_y - P2_y;
        
        int c = a_x*b_y - a_y*b_x;
        if (c > 0) System.out.print(1);
        else if (c < 0) System.out.print(-1);
        else System.out.print(0);
    }
}



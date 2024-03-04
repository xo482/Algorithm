import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
            
        while(true){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            if(x == y && x == 0) break;
            
            if(x % y == 0) System.out.println("multiple");
            else if(y % x == 0) System.out.println("factor");
            else System.out.println("neither");
            
        }
    }
}
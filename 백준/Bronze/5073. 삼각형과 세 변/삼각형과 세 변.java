import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        while(true){
            
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            
            if (x + y + z == 0) break;
            
            if (x+y > z && y+z > x && x+z > y) {
                if (x == y && y == z) System.out.println("Equilateral");
                else if (x != y && y != z && z != x) System.out.println("Scalene");
                else System.out.println("Isosceles");
                
            } else System.out.println("Invalid");
        }
	}
}
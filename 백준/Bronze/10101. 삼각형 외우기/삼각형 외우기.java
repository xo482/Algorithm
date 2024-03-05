import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        int y = Integer.parseInt(br.readLine());
        int z = Integer.parseInt(br.readLine());
        
        if(x+y+z == 180) {
            if(x == y && y == z && z == 60) System.out.print("Equilateral");
            else if (x != y && y != z && x != z) System.out.print("Scalene");
            else System.out.print("Isosceles");
        } else System.out.print("Error");
	}
}
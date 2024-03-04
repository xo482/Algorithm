import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int quarter=0,dime=0, nickel=0, penny=0;
        int length = Integer.parseInt(br.readLine());
        int charge=0;
        
        for(int i=0;i<length;i++){
            charge = Integer.parseInt(br.readLine());
            quarter = charge / 25;
            charge = charge % 25;
            dime = charge / 10;
            charge = charge % 10;
            nickel = charge / 5;
            penny = charge % 5;
            
            System.out.println(quarter + " " + dime + " " + nickel + " " + penny);
        }
        
	}
}
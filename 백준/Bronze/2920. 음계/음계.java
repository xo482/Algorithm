import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        
        if(str.equals("1 2 3 4 5 6 7 8")) System.out.print("ascending");
        else if(str.equals("8 7 6 5 4 3 2 1")) System.out.print("descending");
        else System.out.print("mixed");
        
	}
}

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        int y = (int)Math.pow(2, x);        
        int cnt = (int)Math.pow(y+1, 2);
        
        System.out.println(cnt);
	}
}
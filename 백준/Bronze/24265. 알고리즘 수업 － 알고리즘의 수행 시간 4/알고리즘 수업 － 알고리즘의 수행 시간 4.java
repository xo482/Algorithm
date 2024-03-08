import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long x = Long.parseLong(br.readLine());
        long sum = 0;
        for(int i=1; i<x; i++){
            sum += i;
        }
        System.out.print(sum + "\n2");
	}
}
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] int_arr = new int[10];
        String[] arr = String.valueOf(Integer.parseInt(br.readLine()) 
                                    * Integer.parseInt(br.readLine()) 
                                    * Integer.parseInt(br.readLine()))
                                    .split("");
        
        for(String s : arr) {
            int_arr[Integer.parseInt(s)]++;
        }
        
        for(int i : int_arr) {
            sb.append(i).append("\n");
        }
        System.out.print(sb);
	}
}

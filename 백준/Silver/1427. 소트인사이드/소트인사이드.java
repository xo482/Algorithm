import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] str = br.readLine().split("");
        int len = str.length;
        int[] list = new int[len];
        
        for(int i=0; i < list.length; i++){
            list[i] = Integer.parseInt(str[i]);
        }
        
        Arrays.sort(list);
        
        for(int i = len; i > 0; i--){
            sb.append(list[i-1]);
        }
        
        System.out.print(sb);
	}
}
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        int[] list = new int[cnt];
        
        for(int i=0;i < cnt; i++){
            list[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(list);
        for(int i=0;i < cnt; i++){
            System.out.println(list[i]);
        }
	}
}
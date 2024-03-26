import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[3];
        
        while(true){
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<3; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            if(arr[0] == 0) break;
            
            Arrays.sort(arr);
            
            if (Math.pow(arr[2],2) == Math.pow(arr[0],2) + Math.pow(arr[1],2)) 
                sb.append("right\n");
            else 
                sb.append("wrong\n");
        }
        
        System.out.print(sb);
	}
}
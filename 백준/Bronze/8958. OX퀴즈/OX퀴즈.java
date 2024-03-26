import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        while(N-- > 0) {
            int cnt = 0, sum = 0;
            String str = br.readLine();
            
            for(int i=0; i< str.length(); i++) {
                
                if(str.charAt(i) == 'O') {
                    cnt++;
                } else {
                    cnt = 0;
                }
            
                sum += cnt;
            }
            
            sb.append(sum).append("\n");
        }
        
        System.out.print(sb);
	}
}

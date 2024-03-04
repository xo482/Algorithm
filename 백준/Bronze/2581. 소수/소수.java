import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int x = Integer.parseInt(br.readLine());
        int y = Integer.parseInt(br.readLine());
        int sum = 0;
        int min = -1;
        boolean pass = false;
        
        
        for(int i=x; i<=y; i++){
            if(i == 1) continue;
            for(int j=2;j<i;j++){
                if(i % j == 0) {
                    pass = true;
                    break;
                }
            }
            
            if(pass == false){ 
                if(sum == 0) min = i;
                sum += i;
            }
            
            if(pass == true)
                pass = false;
        }
        
        if(min == -1)
            sb.append(min);
        else
            sb.append(sum).append("\n").append(min);
        
        System.out.print(sb);
	}
}






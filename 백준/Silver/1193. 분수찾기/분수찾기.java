import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        int x=1, y=1;
        boolean direction = true; //true면 오른쪽 false면 왼쪽
        
        for(int i=1; i<len; i++){
            if(x == 1 && y%2 == 1){
                y++;
                direction =false;
            }
            else if(y == 1 && x%2==0){
                x++;                
                direction = true;
            }
            else{
                if(direction == true){
                    x--;
                    y++;
                }else{
                    x++;
                    y--;
                }
            }            
        }
        
        System.out.print(x + "/" + y);
	}
}
import java.io.*;
import java.util.*;
    

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        String[] number = line[0].split("");
        int formation = Integer.parseInt(line[1]);
        int val = 0, total=0;
        
        int index = number.length;
        
        for(int i=0;i<index;i++){
            char ele = number[i].charAt(0);
            
            if(ele >= 'A'){
                val = ele - 'A' + 10;
            } else {
                val = ele - '0';
            }            
            
            total += (val * (Math.pow(formation, index-1-i)));
        }
        
        System.out.print(total);
	}
}
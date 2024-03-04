import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
     
        
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        
        int num = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());
        
        int rNumber = (num % 10) * 100 + ((num / 10) % 10) * 10 + (num / 100);
        int rNumber2 = (num2 % 10) * 100 + ((num2 / 10) % 10) * 10 + (num2 / 100);
        
        if(rNumber > rNumber2)
            System.out.print(rNumber);
        else if(rNumber <= rNumber2)
            System.out.print(rNumber2);
    }
}
import java.io.*;
import java.util.*;
    

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int number = Integer.parseInt(line[0]);
        int formation = Integer.parseInt(line[1]);
        String str = "";
        
        while(number > 0) {
            int remain = number % formation;
            number = number / formation;
           
            if (remain >= 10)
                str += (char)(remain + 55);
            else
                str += (char)(remain + 48);
        }
        
        StringBuffer sb = new StringBuffer(str);
        String reverse = sb.reverse().toString();
        System.out.print(reverse);
	}
}
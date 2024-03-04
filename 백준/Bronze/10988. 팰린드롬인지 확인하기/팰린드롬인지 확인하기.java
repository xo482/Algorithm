import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int len = str.length();
        char[] c = new char[len];
        
        
        for(int i = 0; i < len; i++) {
            c[(len-1)-i] = str.charAt(i);
        }
        
        String new_str = String.valueOf(c);
        
        if(str.equals(new_str)){
            System.out.print(1);
        } else {
            System.out.print(0);
        }
    }
}
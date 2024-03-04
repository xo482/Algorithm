import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int len =  str.length();
        int[] list = new int[len];
        
        for(int i=0; i < len; i++) {
            char c = str.charAt(i);
            
            if('A' <= c && c <= 'C') list[i] = 3;
            if('D' <= c && c <= 'F') list[i] = 4;
            if('G' <= c && c <= 'I') list[i] = 5;
            if('J' <= c && c <= 'L') list[i] = 6;
            if('M' <= c && c <= 'O') list[i] = 7;
            if('P' <= c && c <= 'S') list[i] = 8;
            if('T' <= c && c <= 'V') list[i] = 9;
            if('W' <= c && c <= 'Z') list[i] = 10;
        }
        
        int time = 0;
        for(int i : list) {
            time += i;
        }
        
        System.out.print(time);
    }
}
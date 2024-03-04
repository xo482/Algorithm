import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int len = str.length();
        char[] list = new char[len];
        int cnt = 0;
        
        for(int i = 0; i < len; i++)
            list[i] = (char)str.charAt(i);
        
        for(int i = 0; i < len; i++){
            if(len - i >= 2){
                if(list[i] == 'c' || list[i] == 'd' ||
                   list[i] == 's' || list[i] == 'z'){
                    if(list[i+1] == '=' ||list[i+1] == '-')
                        i++;
                }
                
                if(list[i] == 'l' || list[i] == 'n'){
                    if(list[i+1] == 'j')
                        i++;
                }
            }
            if(len - i >= 3){
                if(list[i] == 'd' && list[i+1] == 'z' && list[i+2] == '=')
                    i += 2;    
            }   
            
            cnt++;
        }
        
        System.out.print(cnt);
    }
}
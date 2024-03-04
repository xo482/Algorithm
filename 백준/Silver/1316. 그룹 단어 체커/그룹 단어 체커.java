import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int iter = Integer.parseInt(br.readLine());
        int cnt = 0;
        
        for(int i = 0; i < iter; i++) {
            String str = br.readLine();
            int len = str.length();
            String alreadyWord = "";
            char continuityWord = '0';
            boolean validate = true;
            
            for(int j = 0; j < len; j++) {
                char word = str.charAt(j);
                
                if(word != continuityWord){
                    if(alreadyWord.contains(String.valueOf(word)))
                        validate = false;
                    else {
                        continuityWord = word;
                        alreadyWord += word;
                    }
                }
            }
            
            if (validate) cnt++;
        }
        
        System.out.print(cnt);
    }
}
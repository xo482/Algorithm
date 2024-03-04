import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] list = new int[26];
        String word = br.readLine();
        
        for(int i = 0; i< 26; i++){
            list[i] = -1;
        }
            
        for(int i = 0; i< word.length(); i++){
            int index = word.charAt(i) - 'a';
            if (list[index] == -1){
                list[index] = i;
            }
        }
   
        
        for(int i = 0; i< 26; i++){
            System.out.print(list[i] + " ");
        }
    }
}

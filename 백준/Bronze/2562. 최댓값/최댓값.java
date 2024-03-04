import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언
        int max = 0;
        int index=0;
        
        for(int i=0;i<9;i++){
            int num = Integer.parseInt(bf.readLine());
            
            if (num >max){
                max = num;
                index = i;
            }
        }
        
        System.out.println(max);
        System.out.println((index+1));
        
    }
}


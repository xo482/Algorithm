import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();
        
        for(int i=1;i<=30;i++){
            list.add(i);
        }
        
        for(int i=0;i<28;i++){
            Integer studentId = Integer.parseInt(br.readLine());
            
            list.remove(studentId);
        }
        

        
        System.out.println(list.get(0));
        System.out.println(list.get(1));
    }
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();

        for(int i=0;i<10;i++){
            int number = Integer.parseInt(br.readLine());
            
            int remain = number % 42;
            
            if (!list.contains(remain)){
                list.add(remain);
            }
        }
        
        System.out.print(list.size());

    }
}
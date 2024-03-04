import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        int i, reward, max;
        
        for(i=0;i<3;i++){
            list.add(sc.nextInt());
        }
        
        if(list.get(0) == list.get(1) && list.get(1) == list.get(2) && list.get(2) == list.get(0))
            reward = 10000 + list.get(0) * 1000;
        else if(list.get(0) != list.get(1) && list.get(1) != list.get(2) && list.get(2) != list.get(0)){
            max = Collections.max(list);
            reward = max * 100;
        }
        else{
            if(list.get(0) == list.get(1) || list.get(0) == list.get(2))
                max = list.get(0);
            else
                max = list.get(1);
            
            reward = 1000 + max * 100;
        }
        
        
        System.out.print(reward);
    }
}
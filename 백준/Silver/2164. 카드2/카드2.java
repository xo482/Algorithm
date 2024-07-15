import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayDeque<Integer> Card = new ArrayDeque<>();

        int N = sc.nextInt();
        for(int i=1; i<=N; i++){
            Card.add(i);
        }

        while(Card.size() != 1){
            Card.removeFirst();
            Card.addLast(Card.removeFirst());
        }

        System.out.println(Card.getFirst());

        Card.removeFirst();
    }
}
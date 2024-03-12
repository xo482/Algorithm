import java.io.*;
import java.util.*;

public class Main {

    static int kingX;
    static int kingY;
    static int rockX;
    static int rockY;

    public static void move(int y, int x){
        if((kingX+x) == rockX && (kingY+y) == rockY){
            if((0 <= rockX+x && rockX+x <= 7) && (0 <= rockY+y && rockY+y <= 7)){
                kingX += x;
                kingY += y;
                rockX += x;
                rockY += y;
            }

        }
        else{
            if((0 <= kingX+x && kingX+x <= 7) && (0 <= kingY+y && kingY+y <= 7)){
                kingX += x;
                kingY += y;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] init = br.readLine().split(" ");
        kingX = init[0].charAt(0) - 'A';
        kingY = init[0].charAt(1) - '1';
        rockX = init[1].charAt(0) - 'A';
        rockY = init[1].charAt(1) - '1';

        int N = Integer.parseInt(init[2]);
        while(N-- >0){
            String direction = br.readLine();
            if(direction.equals("L")){
                move(0,-1);
            }
            if(direction.equals("R")){
                move(0,1);
            }
            if(direction.equals("T")){
                move(1,0);
            }
            if(direction.equals("B")){
                move(-1,0);
            }
            if(direction.equals("LT")){
                move(1,-1);
            }
            if(direction.equals("LB")){
                move(-1,-1);
            }
            if(direction.equals("RT")){
                move(1,1);
            }
            if(direction.equals("RB")){
                move(-1,1);
            }
        }

        System.out.print((char)(kingX + 'A'));
        System.out.println((kingY+1));
        System.out.print((char)(rockX + 'A'));
        System.out.println((rockY+1));
    }
}
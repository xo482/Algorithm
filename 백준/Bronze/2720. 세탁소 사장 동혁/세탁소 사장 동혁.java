import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new Bufferedwriter(new OutputStreamWriter(System.in));
        int T = Integer.parseInt(br.readLine());
        //순서대로 쿼터, 다임, 니켈, 페니
        int q,d,n,p = 0;
        for(int i=0; i<T; i++){
            int C = Integer.parseInt(br.readLine());
            q = C/25;
            d = (C-(25*q))/10;
            n = (C-(25*q+10*d))/5;
            p = (C-(25*q+10*d+5*n))/1;
            System.out.println(q + " " + d + " " + n + " " + p);
        }
    }
}
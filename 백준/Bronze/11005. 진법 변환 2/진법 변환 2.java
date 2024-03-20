import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] in = br.readLine().split(" ");
        int[] input = new int[in.length];
        for(int i=0; i<in.length; i++) {
        	input[i] = Integer.parseInt(in[i]);
        }
        int N = input[0];
        int B = input[1];
        //bw.write(Integer.toString(N, B));
        System.out.println(Integer.toString(N, B).toUpperCase());
    }
}
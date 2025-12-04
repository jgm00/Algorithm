import java.util.*;
import java.io.*;

public class Main
{
    static int N,S;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	N = Integer.parseInt(br.readLine());
    	S = Integer.parseInt(br.readLine());
        if(N<=S){
            System.out.print("high speed rail");
        }else{
            System.out.print("flight");
        }
	}
}
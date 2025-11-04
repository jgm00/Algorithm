import java.util.*;
import java.io.*;

public class Main
{
    static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        if(90 <= N && N <= 100){
            System.out.println("A");
        }else if(80 <= N && N < 90){
            System.out.println("B");
        }else if(70 <= N && N < 80){
            System.out.println("C");
        }else if(60 <= N && N < 70){
            System.out.println("D");
        }else if(N < 60){
            System.out.println("F");
        }
	}
}
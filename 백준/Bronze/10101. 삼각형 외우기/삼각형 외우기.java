import java.util.*;
import java.io.*;

public class Main
{
    static int a,b,c;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		a = Integer.parseInt(br.readLine());
		b = Integer.parseInt(br.readLine());
		c = Integer.parseInt(br.readLine());
        if(a+b+c == 180){
            if(a==60 && b == 60){
                System.out.println("Equilateral");
            }else if(a==b || b==c || a==c){
                System.out.println("Isosceles");
            }else if(a!=b && b!=c || a!= c && b!= c){
                System.out.println("Scalene");
            }
        }else{
            System.out.println("Error");
        }
	}
}
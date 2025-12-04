import java.util.*;
import java.io.*;

public class Main
{
    static int[] num;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num = new int[3];
        for(int i=0;i<3;i++){
            num[i]= Integer.parseInt(br.readLine());
        }
        Arrays.sort(num);
        System.out.println(num[1]);
	}
}
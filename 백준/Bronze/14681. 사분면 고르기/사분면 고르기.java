import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        int y = Integer.parseInt(br.readLine());
        int ans = 0;
        if(x > 0 && y > 0){
            ans = 1;
        }else if(x < 0 && y > 0){
            ans = 2;
        }else if( x < 0 && y < 0){
            ans = 3;
        }else if( x > 0 && y < 0){
            ans = 4;
        }
        System.out.println(ans);
	}
}
import java.util.*;
import java.io.*;

public class Main
{
    static int N,M,ansx,ansy;
    static int[] numx,numy;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		numx = new int[3]; numy = new int[3];
		for(int i=0;i<3;i++){
		    StringTokenizer st = new StringTokenizer(br.readLine());
		    int x = Integer.parseInt(st.nextToken());
		    int y = Integer.parseInt(st.nextToken());
		    numx[i] = x;
		    numy[i] = y;
		}
		if(numx[0] == numx[1]){
		    ansx = numx[2];
		}else if(numx[0] == numx[2]){
		    ansx = numx[1];
		}else if(numx[1] == numx[2]){
		    ansx = numx[0];
		}
		if(numy[0] == numy[1]){
		    ansy = numy[2];
		}else if(numy[0] == numy[2]){
		    ansy = numy[1];
		}else if(numy[1] == numy[2]){
		    ansy = numy[0];
		}
		System.out.println(ansx + " " + ansy);
	}
}
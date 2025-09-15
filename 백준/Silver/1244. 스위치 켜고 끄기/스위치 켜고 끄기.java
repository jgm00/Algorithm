import java.util.*;
import java.io.*;

public class Main
{
    static int N,M;
    static int[] swtch;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		swtch = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++){
		    swtch[i] = Integer.parseInt(st.nextToken());
		}
		M = Integer.parseInt(br.readLine());
		for(int i=0;i<M;i++){
		    st = new StringTokenizer(br.readLine());
		    int a = Integer.parseInt(st.nextToken());
		    int b = Integer.parseInt(st.nextToken());
		    if( a == 1){
		        for(int j=1;j<=N;j++){
		            if(j % b == 0){
		                swtch[j] = 1- swtch[j];
		            }
		        }
		    }else{
		        int d = Math.min((b-1),(N-b));
		        swtch[b] = 1 - swtch[b];
		        for(int j=1;j<=d; j++){
		            if(swtch[b+j] == swtch[b-j]){
		                 swtch[b+j] = 1 - swtch[b+j];
		                 swtch[b-j] = 1 - swtch[b-j];
		            }else{
		                break;
		            }
		        }
		    }
		}
		for(int i=1;i<=N;i++){
		    System.out.print(swtch[i] + " ");
		    if(i%20 == 0){
                System.out.println();
            }
        }
	}
}
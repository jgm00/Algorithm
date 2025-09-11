import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<String> alist = new ArrayList<>();
    static int N;
    static String[] ch;
    static int[] arr, vis;
    static boolean chk(int num, int id){
        if(ch[id-1].equals("<")){
            if(arr[id-1] < num){
                return true;
            }
        }else{
            if(arr[id-1] > num){
                return true;
            }
        }
        return false;
    }
    static void dfs(int k){
        if(k==(N+1)){
            String s = "";
            for(int i=0;i<(N+1);i++){
                s += arr[i];
            }
            alist.add(s);
            return;
        }
        for(int i=0;i<=9;i++){
            if(vis[i] == 1) continue;
            if(k==0){
                arr[k] = i;
                vis[i] = 1;
                dfs(k+1);
                vis[i] = 0;
            }else{
                if(chk(i,k)){
                    arr[k] = i;
                    vis[i] = 1;
                    dfs(k+1);
                    vis[i] = 0;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ch = new String[N];
        vis = new int[10];
        arr = new int[N+1];
        for(int i=0;i<N;i++){
            ch[i] = st.nextToken();
        }
        dfs(0);
        Collections.sort(alist);
        System.out.println(alist.get(alist.size()-1));
        System.out.println(alist.get(0));
    }
}

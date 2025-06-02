/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;
import java.io.*;


public class Main
{   
    static String make(int k){
        String str = "";
        String str1 = "";
        while(k>0){
            int k1 = k%2;
            str += Integer.toString(k1);
            k /= 2;
        }
        while(str.length()<3){
            str += "0";
        }
        for(int i = str.length() - 1;i>=0;i--){
            str1 += str.charAt(i);
        }
        return str1;
    }
    static String make2(int k){
        String str = "";
        String str1 = "";
        while(k>0){
            int k1 = k%2;
            str += Integer.toString(k1);
            k /= 2;
        }
        while(str.length()<4){
            str += "0";
        }
        for(int i = str.length() - 1;i>=0;i--){
            str1 += str.charAt(i);
        }
        return str1;
    }
    static int N;
    static HashMap<String, String> hmap;
    static String opt;
    static int rA, rB, rD;
    static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		hmap = new HashMap<>();
		hmap.put("ADD","0000"); hmap.put("ADDC", "0000");
        hmap.put("SUB", "0001"); hmap.put("SUBC", "0001"); hmap.put("MOV", "0010");
        hmap.put("MOVC", "0010"); hmap.put("AND", "0011"); hmap.put("ANDC", "0011");
        hmap.put("OR", "0100"); hmap.put("ORC", "0100"); hmap.put("NOT", "0101"); 
        hmap.put("MULT", "0110"); hmap.put("MULTC", "0110"); hmap.put("LSFTL", "0111"); 
        hmap.put("LSFTLC", "0111"); hmap.put("LSFTR", "1000"); hmap.put("LSFTRC", "1000"); 
        hmap.put("ASFTR", "1001"); hmap.put("ASFTRC", "1001"); 
        hmap.put("RL", "1010"); hmap.put("RLC", "1010");
        hmap.put("RR", "1011"); hmap.put("RRC", "1011");
		N = Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++){
		    StringTokenizer st = new StringTokenizer(br.readLine());
		    sb = new StringBuilder();
		    opt = st.nextToken();
		    rD = Integer.parseInt(st.nextToken());
		    rA = Integer.parseInt(st.nextToken());
		    rB = Integer.parseInt(st.nextToken());
		    sb.append(hmap.get(opt));
    	    if(opt.charAt(opt.length() - 1) == 'C'){
    	        sb.append("10");
    	    }else{
    	      sb.append("00");
    	    };
    	    sb.append(make(rD));
    	    if(opt == "MOV" || opt == "MOVC" || opt == "NOT"){
    	        sb.append("000");
    	    }else{
    	        sb.append(make(rA));
    	    }
    	    if(opt.charAt(opt.length() - 1) == 'C'){
    	        sb.append(make2(rB));
    	    }else{
    	      sb.append(make(rB));
    	      sb.append("0");
    	    };
    	    System.out.println(sb);
	    }
	}
}
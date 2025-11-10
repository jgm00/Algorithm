import java.util.*;
import java.io.*;

public class Main {
    static String S;
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        int i = Integer.parseInt(br.readLine());
        System.out.println(S.charAt(i-1));
    }
}


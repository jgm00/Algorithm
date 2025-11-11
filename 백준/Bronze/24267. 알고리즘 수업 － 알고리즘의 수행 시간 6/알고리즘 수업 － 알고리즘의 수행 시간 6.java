import java.util.*;
import java.io.*;

public class Main {
    static long N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Long.parseLong(br.readLine());
        System.out.println((N-2)*(N-1)*(N) / 6);
        System.out.println(3);
    }
}
import java.util.*;
import java.io.*;

public class Main {
    static int X;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        X = Integer.parseInt(br.readLine());
        System.out.println((long) X*X*X);
        System.out.println(3);
    }
}
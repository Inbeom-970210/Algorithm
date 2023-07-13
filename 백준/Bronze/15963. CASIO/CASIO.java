import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        long N = sc.nextLong();
        long M = sc.nextLong();
        
        if(N == M) {
            System.out.print(1);
        }
        else {
            System.out.print(0);
        }
    }
}
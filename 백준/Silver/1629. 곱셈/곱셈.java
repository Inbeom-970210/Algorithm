import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        
        long res = pow(A, B, C);
        
        System.out.print(res);
    }
    
    public static long pow(int A, int B, int C) {
        if(B == 0) return 1;
        
        long half = pow(A, B / 2, C);
        
        if(B % 2 == 0) return half * half % C;
        else return (half * half % C) * A % C; 
    }
}
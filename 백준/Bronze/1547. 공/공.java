import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int[] arr = new int[4];
        for(int i = 1; i < 4; i++) {
            arr[i] = i;
        }
        
        int m = sc.nextInt();
        for(int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            
            int repo = arr[x];
            arr[x] = arr[y];
            arr[y] = repo;
        }
        
        for(int i = 1; i < 4; i++) {
            if(arr[i] == 1) {
                System.out.print(i);
                break;
            }
        }
    }
}
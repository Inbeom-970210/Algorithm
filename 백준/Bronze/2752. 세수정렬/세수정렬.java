import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int[] arr = new int[3];
        for(int i = 0; i < 3; i++) {
            arr[i] = sc.nextInt();
        }
        
        for(int i = 0; i < 2; i++) {
            int min = i;
            
            for(int j = i + 1; j < 3; j++) {
                if(arr[min] > arr[j]) {
                    min = j;
                }
            }
        
            int repo = arr[i];
            arr[i] = arr[min];
            arr[min] = repo;
        }
        
        for(int i = 0; i < 3; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[9];
		int sum = 0;
		for(int i = 0; i < 9; i++) {
			arr[i] = sc.nextInt();
			sum += arr[i];
		}
		
		int index1 = 0, index2 = 0;
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9 && j != i; j++) {
				if(sum - arr[i] - arr[j] == 100) {
					index1 = i;
					index2 = j;
				}
			}
		}
		
		arr[index1] = 100;
		arr[index2] = 100;
		int minIndex = 0;
		
		for(int i = 0, ram = 0; i < 9; i++) {
			for(int j = i + 1; j < 9; j++) {
				if(arr[minIndex] > arr[j]) {
					minIndex = j;
				}
			}
			
			ram = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = ram;
			minIndex = i + 1;
		}
		
		for(int i = 0; i < 7; i++) {
			System.out.println(arr[i]);
		}
	}
}
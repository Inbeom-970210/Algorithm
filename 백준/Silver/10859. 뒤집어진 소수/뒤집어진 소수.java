import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N은 첫 숫자가 0이 아닌 수; 1 <= N <= 10^16
        // 1일 때는 예외처리
        String stringN = br.readLine();
        long N = Long.parseLong(stringN);
        if(N == 1) {
            System.out.print("no");
            return;
        }

        // N이 소수인지 판단 후
        // 소수이면 종료, N이 3, 4, 7을 포함하면 종료
        String preNum = PN(N);
        if (preNum.equals("no")) {
            System.out.print("no");
            return;
        }

        if (stringN.contains("3") || stringN.contains("4") || stringN.contains("7")) {
            System.out.print("no");
            return;
        }

        // N을 배열로 바꿔 뒤에서부터 각 인덱스에 접근
        // 0, 1, 2, 5, 8이면 이를 그대로 저장
        // 6, 9이면 180도 뒤집어 저장
        // 구한 값을 long으로 변환 후 소수 판별
        char[] arr = stringN.toCharArray();
        String stringR = "";
        for (int idx = arr.length - 1; idx >= 0; idx--) {
            if (arr[idx] == '0' || arr[idx] == '1' || arr[idx] == '2' || arr[idx] == '5' || arr[idx] == '8')
                stringR += Character.toString(arr[idx]);
            if(arr[idx] == '6') stringR += "9";
            if(arr[idx] == '9') stringR += "6";
        }

        long reverseN = Long.parseLong(stringR);
        System.out.print(PN(reverseN));
    }

    // 입력된 수가 소수인지 판단하는 메서드
    private static String PN(long num) {
        String res = "yes";
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                res = "no";
                break;
            }
        }

        return res;
    }

}
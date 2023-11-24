import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<Character> deque = new ArrayDeque<>();

        boolean check = false;
        char[] arr = br.readLine().toCharArray();
        int len = arr.length;

        for (int i = 0; i < len; i++) {
            switch (arr[i]) {
                case '<':
                    check = true;
                    while (!deque.isEmpty()) {
                        sb.append(deque.pollLast());
                    }
                    sb.append(arr[i]);
                    break;
                case '>':
                    check = false;
                    sb.append(arr[i]);
                    break;
                case ' ':
                    while (!deque.isEmpty()) {
                        sb.append(deque.pollLast());
                    }
                    sb.append(arr[i]);
                    break;
                default:
                    if (check) {
                        sb.append(arr[i]);
                    } else {
                        deque.offerLast(arr[i]);
                    }
                    break;
            }
        }
        while (!deque.isEmpty()) {
            sb.append(deque.pollLast());
        }

        System.out.print(sb);
    }
}
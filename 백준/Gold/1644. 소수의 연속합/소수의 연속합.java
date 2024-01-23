import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N은 연속된 소수의 합 조건이 되는 자연수; 1 <= N <= 4,000,000
        int N = Integer.parseInt(br.readLine());
        if (N == 1) {
            System.out.print(0);
            return;
        }

        boolean[] isPrime = new boolean[N + 1];
        for (int i = 2; i <= Math.sqrt(N); ++i) {
            if(isPrime[i]) continue;
            for (int j = i * 2; j <= N; j += i) {
                isPrime[j] = true;
            }
        }

        int iCnt = 0;
        for (int i = 2; i <= N; ++i) {
            isPrime[i] = !isPrime[i];
            if (isPrime[i]) ++iCnt;
        }

        int[] primes = new int[iCnt];
        int idx = 0;
        for (int i = 2; i <= N; ++i) {
            if (isPrime[i]) primes[idx++] = i;
        }

        int res = 0;
        int sum = 0;
        int s = 0;
        int e = -1;
        while (sum < N) {
            sum += primes[++e];
        }

        while (s < e && sum - primes[s] >= N) {
            sum -= primes[s++];
        }
        if (sum == N) ++res;
//        System.out.println("primes[" + s + "]:" + primes[s] + " // primes[" + e + "]:" + primes[e] + " // res: " + res);

        while (e < iCnt - 1) {
            sum += primes[e++ + 1];

            while (s < e && sum - primes[s] >= N) {
                sum -= primes[s++];
            }
            if (sum == N) ++res;

//            System.out.println("primes[" + s + "]:" + primes[s] + " // primes[" + e + "]:" + primes[e] + " // res: " + res);
        }

        System.out.print(res);

    }
}
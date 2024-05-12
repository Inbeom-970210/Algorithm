class Solution {
    private final int mod = 1000000007;
    
    public int solution(int n) {
        long[] DP = new long[n + 1];
        long[] DP4 = new long[n + 1];
        long[] DP5 = new long[n + 1];
        long[] DP6 = new long[n + 1];
        DP[0] = 1;
        
        for(int i = 1; i <= n; i++) {
            if(i >= 1) DP[i] = (DP[i] + DP[i - 1]) % mod;
            if(i >= 2) DP[i] = (DP[i] + DP[i - 2] * 2) % mod;
            if(i >= 3) DP[i] = (DP[i] + DP[i - 3] * 5) % mod;
            if(i >= 4) {
                long diff = DP[i - 4] * 2 % mod;
                DP4[i] = (DP4[i - 3] + diff) % mod;
                DP[i] = (DP[i] + DP4[i]) % mod;
            }
            if(i >= 5) {
                long diff = DP[i - 5] * 2 % mod;
                DP5[i] = (DP5[i - 3] + diff) % mod;
                DP[i] = (DP[i] + DP5[i]) % mod;
            }
            if(i >= 6) {
                long diff = DP[i - 6] * 4 % mod;
                DP6[i] = (DP6[i - 3] + diff) % mod;
                DP[i] = (DP[i] + DP6[i]) % mod;
            }
        }
        
        return Math.toIntExact(DP[n]);
    }
}
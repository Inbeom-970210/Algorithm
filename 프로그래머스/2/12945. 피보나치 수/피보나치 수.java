class Solution {
    private int[] F;
    
    public int solution(int n) {
        F = new int[n + 1];
        F[0] = 0;
        F[1] = 1;
        
        return findF(n) % 1234567;
    }
    
    private int findF(int n) {
        if (n > 1 && F[n] == 0)
            F[n] = (findF(n - 1) + findF(n - 2)) % 1234567;
        
        return F[n];
    }
}
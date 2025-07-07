class Solution {
    public int solution(int n) {
        int len = Integer.toBinaryString(n).replace("0", "").length();
        int next = n + 1;
        while(true) {
            if(Integer.toBinaryString(next).replace("0", "").length() == len) {
                return next;
            }
            next++;
        }
    }
}
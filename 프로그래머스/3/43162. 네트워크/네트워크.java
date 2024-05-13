import java.util.*;

class Solution {
    private int[] parent;
    
    public int solution(int n, int[][] computers) {
        Set<Integer> set = new HashSet<>();
        int len = computers.length;
        
        parent = new int[len];
        for(int i = 0; i < len; i++) {
            parent[i] = i;
        }
        
        for(int r = 0; r < len; r++) {
            for(int c = r + 1; c < len; c++) {
                if(computers[r][c] == 1) {
                    union(r, c);
                }
            }
        }
        
        for(int i = 0; i < len; i++) {
            parent[i] = find(i);
            set.add(parent[i]);
        }
        
        return set.size();
    }
    
    public void union(int r, int c) {
        int parentR = find(r);
        int parentC = find(c);
        
        if(parentR == parentC) return;
        if(parentR < parentC) parent[parentC] = parentR;
        else parent[parentR] = parentC;
    }
    
    public int find(int r) {
        if(r == parent[r]) return r;
        else return find(parent[r]);
    }
    
}
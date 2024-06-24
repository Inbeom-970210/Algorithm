import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        s = s.substring(2, s.length() - 2);
        s = s.replace("},{", "/");
        String[] arr = s.split("/");
        Arrays.sort(arr, new Comparator<String>() {
            public int compare(String o1, String o2) {
                if(o1.length() <= o2.length()) return -1;
                else return 1;
            }
        });
        
        List<Integer> answer = new ArrayList<>();
        for(String val : arr) {
            String[] temp = val.split(",");
            for(String item : temp) {
                int num = Integer.parseInt(item);
                if(!answer.contains(num)) answer.add(num);
            }
        }
        
        int[] res = new int[answer.size()];
        int idx = -1;
        for(int val : answer) {
            res[++idx] = val;
        }
        
        return res;
    }
}
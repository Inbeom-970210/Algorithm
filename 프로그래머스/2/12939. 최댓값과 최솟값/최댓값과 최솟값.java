import java.util.*;

class Solution {
    public String solution(String s) {
        String[] arr = s.split(" ");
        List<Integer> list = new ArrayList<>();
        for(String item : arr) {
            list.add(Integer.parseInt(item));
        }
        list.sort(Comparator.naturalOrder());
        
        
        return list.get(0) + " " + list.get(list.size() - 1);
    }
}
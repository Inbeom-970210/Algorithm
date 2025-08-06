class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        
        boolean flag = true;
        for(String str : s.split("")) {
            if(flag && !str.equals(" ")) {
                flag = false;
                if(str.matches("[a-z | A-Z]")) {
                    sb.append(str.toUpperCase());
                    continue;
                }
            } else if(str.equals(" ")) {
                flag = true;
            }
            sb.append(str.toLowerCase());
        }
        
        return sb.toString();
    }
}
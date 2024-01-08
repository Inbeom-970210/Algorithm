class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        boolean[] alphas = new boolean[26];
        for(int i = 0; i < skill.length(); i++) {
            alphas[skill.charAt(i) - 'A'] = true;
        }
        
        loof: for(String skill_tree : skill_trees) {
            int idx = 0;
            for(int i = 0; i < skill_tree.length(); i++) {
                if(!alphas[skill_tree.charAt(i) - 'A']) continue;
                
                if(skill.charAt(idx) == skill_tree.charAt(i)) idx++;
                else continue loof;
            }
            
            answer++;
        }
        
        return answer;
    }
}
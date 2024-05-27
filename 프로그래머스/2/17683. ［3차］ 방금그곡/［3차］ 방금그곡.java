class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        
        int length = musicinfos.length;
        int[] times = new int[length];
        String[] titles = new String[length];
        int idx = -1;
        int max = Integer.MIN_VALUE;
        
        for(String music : musicinfos) {
            String[] detail = music.split(",");
            String[] start = detail[0].split(":");
            String[] end = detail[1].split(":");
            int startHour = Integer.parseInt(start[0]);
            int startMin = Integer.parseInt(start[1]);
            int endHour = Integer.parseInt(end[0]);
            int endMin = Integer.parseInt(end[1]);
            if(endHour < startHour ||
               endHour == startHour && endMin < startMin) {
                endHour = 24;
                endMin = 00;
            }
            int time =  (endHour - startHour) * 60 + (endMin - startMin);
            String title = detail[2];
            String[] info = detail[3].split("");
            String listen = "";
            
            int len = info.length;
            int index = 0;
            for(int t = 1; t <= time; t++) {
                listen += info[index++ % len];    
                if(info[index % len].equals("#")) {
                    listen += info[index++ % len];
                } 
            }
            
            if(listen.replace(m + "#", "").contains(m)) {
                times[++idx] = time;
                titles[idx] = title;
                max = Math.max(max, time);
            }
            else {
                titles[++idx] = title;
            }
        }
        
        if(max != Integer.MIN_VALUE) {
            for(int i = 0; i < length; i++) {
               if(times[i] == max) {
                    answer = titles[i];
                    break;
                }
            }
        }
        
        return answer;
    }
}
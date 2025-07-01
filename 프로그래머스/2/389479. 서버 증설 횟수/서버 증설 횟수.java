class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int[] addedServer = new int[24];
        for(int i = 0; i < players.length; i++) {
            if(players[i] < m) continue;
            answer += getNeedServer(i, k, players[i] / m, addedServer);
        }
        
        return answer;
    }
    
    private int getNeedServer(int location, int time, int server, int[] addedServer) {
        int needServer = 0;
        if(server > addedServer[location]) {
            needServer = server - addedServer[location];
            for(int i = 0; i < time; i++) {
                if(location + i >= 24) break;
                addedServer[location + i] += needServer;
            }
        }
        return needServer;
    }
}
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Queue<int[]> q = new LinkedList<>();				// 위상정렬을 위한 q
		StringBuilder sb = new StringBuilder();				// 결과 출력을 위한 sb
		int N = sc.nextInt();								// 1 <= N(건물의 종류 수) <= 500
		int[] res = new int[N + 1];							// 건물이 완성되기까지 걸리는 최소 시간
		int[] time = new int[N + 1];						// 건물을 짖는데 걸리는 시간	<= 100,000
		int[] startTime = new int[N + 1];					// 건설 시작 시간
		int[] inDegree = new int[N + 1];					// 사전 건설 완료가 필요한 건물의 개수
		ArrayList<Integer>[] list = new ArrayList[N + 1];	// index 건물의 건설 완료가 필요한 건물들
		for(int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 1; i <= N; i++) {	// list, time, inDegree 입력
			time[i] = sc.nextInt();
			while(true) {
				int num = sc.nextInt();	// i 건물을 짖기 전 건설 완료가 필요한 건물
				if(num == -1) break;	// -1이 입력되면 다음 다음 건물 고려
				
				list[num].add(i);
				inDegree[i]++;
			}
		}
		
		// 위상 정렬
		// 사전 건설 완료가 필요 없는 건물들 건설
		for(int i = 1; i <= N; i++) {
			if(inDegree[i] == 0) {
				q.offer(new int[] {i, time[i]});	// q에 건물 번호, 건설 완료 시간 입력
			}
		}
		
		// q가 비면 사이클 생겼거나, 정렬된 상태이다
		while(!q.isEmpty()) {
			int[] curr = q.poll();	// 현재 건설 완료된 curr 건물 번호(0), 완료 시간(1)
			res[curr[0]] = curr[1];	// 완료시간 res에 입력
			
			// curr 건설 이후 지을 수 있는 건물들 탐색
			for(int next : list[curr[0]]) {
				inDegree[next]--;	// 진입 차수 -1
				startTime[next] = Math.max(startTime[next], curr[1]);	// 건설 시작 시간을 구함 (사전 건설 건물들의 완료 시간 중 가장 큰 값)
				
				if(inDegree[next] == 0) q.offer(new int[] {next, startTime[next] + time[next]});	// 진입 차수가 0이면 건설
			}
		}
		
		// sb에 결과값 입력
		for(int endTime : res) {
			if(endTime == 0) continue;
			sb.append(endTime).append("\n");
		}
		
		// sb 출력
		System.out.println(sb);
	}
}
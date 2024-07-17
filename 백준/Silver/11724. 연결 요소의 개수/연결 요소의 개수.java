import java.util.Scanner;

public class Main {
	static int[] P;
	static int[] rank;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();					// 1 <= N(정점의 개수) <= 1,000
		int M = sc.nextInt();					// 0 <= M(간선의 개수) <= N * (N - 1) / 2
		int[][] edges = new int[M + 1][2];		// 간선의 정보
		for(int r = 1; r <= M; r++) {
			edges[r][0] = sc.nextInt();			// 0 : 시작 정점
			edges[r][1] = sc.nextInt();			// 1 : 끝 정점
		}
		
		P = new int[N + 1];						// 대표를 저장할 배열
		rank = new int[N + 1];					// rank를 저장할 배열
		for(int i = 1; i <= N; i++) {			// makeset
			P[i] = i;
		}
		int pick = 0;							// 선택한 간선의 개수
		
		for(int i = 1; i <= M; i++) {
			int px = findset(edges[i][0]);
			int py = findset(edges[i][1]);
			
			if(px == py) continue;				// 사이클이 생기는 경우 넘어가서 다음 간선 고려
			
			Union(px, py);						// 두 정점 연결
			pick++;								// 선택한 간선의 개수 카운트
			
			if(pick == N - 1) break;			// 간선을 N - 1개 뽑았으면 종료
		}
		
		for(int i = 1; i <= N; i++)
			findset(i);							// P가 각 정점의 대표값을 가지게 findset
		
		int res = 0;							// 연결 요소의 개수
		boolean[] visited = new boolean[N + 1];	// 연결 요소를 확인하기 위한 배열
		
		for(int i = 1; i <= N; i++) {			// 모든 정점의 대표값을 확인			
			if(visited[P[i]]) continue;			// 확인된 대표값이면 다음 대표값 확인
			
			res++;								// 연결 요소 개수 카운트
			visited[P[i]] = true;				// 대표값 확인 체크
		}
		
		System.out.println(res);				// 연결 요소의 개수 출력
	}

	public static void Union(int x, int y) {
		if(rank[x] > rank[y]) P[y] = x;
		else {
			P[x] = y;
			if(rank[x] == rank[y]) rank[y]++;
		}
	}

	public static int findset(int x) {
		if(x != P[x]) P[x] = findset(P[x]);
		return P[x];
	}
}
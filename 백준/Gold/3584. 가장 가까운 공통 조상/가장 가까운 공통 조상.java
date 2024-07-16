import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int answer = 0;
        List<Node> graph = new ArrayList<>();
        List<Node> ancestors = new ArrayList<Node>();

        int T = Integer.parseInt(br.readLine());
        for (int test = 0; test < T; test++) {
            answer = solution(graph, ancestors);
            sb.append(answer).append("\n");
            clear(graph, ancestors);
        }

        System.out.println(sb);
    }

    private static int solution(List<Node> graph, List<Node> ancestors) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        init(N, graph);
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int parentNum = Integer.parseInt(st.nextToken());
            int childNum = Integer.parseInt(st.nextToken());
            Node parent = graph.get(parentNum);
            Node child = graph.get(childNum);
            child.parent = parent;
        }

        st = new StringTokenizer(br.readLine());
        Node node1 = graph.get(Integer.parseInt(st.nextToken()));
        Node node2 = graph.get(Integer.parseInt(st.nextToken()));
        while (node1 != null) {
            ancestors.add(node1);
            node1 = node1.parent;
        }

        while (node2 != null) {
            if (ancestors.contains(node2)) {
                answer = node2.value;
                break;
            }
            node2 = node2.parent;
        }

        return answer;
    }

    private static void init(int N, List<Node> graph) {
        for (int i = 0; i <= N; i++) {
            graph.add(new Node(i));
        }
    }

    private static void clear(List<Node> graph, List<Node> ancestors) {
        graph.clear();
        ancestors.clear();
    }


}

class Node {
    int value;
    Node parent;

    public Node(int value) {
        this.value = value;
    }
}
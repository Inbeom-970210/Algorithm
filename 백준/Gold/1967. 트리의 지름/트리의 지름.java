import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        answer = 0;

        int n = Integer.parseInt(br.readLine());
        List<Node> graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new Node(i));
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int parentNum = Integer.parseInt(st.nextToken());
            int childNum = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            Node parent = graph.get(parentNum);
            Node child = graph.get(childNum);
            child.parent = parent;
            child.toParent = value;
            parent.childs.add(child);
        }

        dfs(1, graph);

        System.out.print(answer);
    }

    private static int dfs(int location, List<Node> graph) {
        Node cur = graph.get(location);

        if (cur.childs.size() == 0) return 0;

        if (cur.maxValue == 0) {
            int max = 0;
            int next = 0;
            for (Node child : cur.childs) {
                if (child.location == 0) continue;
                max = Math.max(max, dfs(child.location, graph) + child.toParent);
            }
            boolean flag = false;
            for (Node child : cur.childs) {
                if (child.location == 0) continue;

                if (child.maxValue + child.toParent == max && !flag) {
                    flag = true;
                    continue;
                }
                if (child.maxValue + child.toParent == max && flag) {
                    next = max;
                    break;
                }

                next = Math.max(next, child.maxValue + child.toParent);
            }

            answer = Math.max(answer, max + next);
            cur.maxValue = max;
        }
        return cur.maxValue;
    }
}

class Node {
    int location;
    int maxValue;
    Node parent;
    int toParent;
    List<Node> childs;

    public Node(int location) {
        this.location = location;
        this.childs = new ArrayList<>();
    }
}
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private static Set<Node> visited;

    public static void main(String[] args) {

        Main main = new Main();
        visited = new HashSet<>();
        main.go();

    }

    private void go() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);

        node1.addEdgeToNode(node2);
        node1.addEdgeToNode(node3);
        node2.addEdgeToNode(node4);
        node2.addEdgeToNode(node5);
        node3.addEdgeToNode(node4);
        node4.addEdgeToNode(node4);
        node4.addEdgeToNode(node5);
        node4.addEdgeToNode(node6);
        node6.addEdgeToNode(node7);
        node6.addEdgeToNode(node8);
        node7.addEdgeToNode(node8);

        List<Node> graph = Arrays.asList(node1, node2, node3, node4, node5, node6, node7, node8);

        for (Node node : graph) {
            if (!visited.contains(node)) {
                depthSearch(node);
            }
        }

    }

    private void depthSearch(Node node) {
        visited.add(node);
        //visited.forEach(System.out::print);
        System.out.println(node);
        Set<Node> neighbor = new HashSet<>();
        node.getEdges().stream().map(Edge::getNodes).flatMap(Collection::stream).forEach(n -> {if (!n.equals(node)) neighbor.add(n);});
        neighbor.forEach(n ->{if (visited.add(n)) depthSearch(node);});
    }

}

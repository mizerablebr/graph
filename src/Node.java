import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Node {
    private int name;
    private Set<Edge> edges;

    public Node(int name) {
        this.name = name;
        this.edges = new HashSet<>();
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public Set<Edge> getEdges() {
        return edges;
    }

    public void setEdges(Set<Edge> edges) {
        this.edges = edges;
    }

    public boolean addEdge(Edge edge) {
        return edges.add(edge);
    }

    public Node addEdgeToNode(Node node) {
        addEdge(new Edge(this, node));
        node.addEdge(new Edge(node, this));
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;
        Node node = (Node) o;
        return getName() == node.getName();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getName());
    }

    @Override
    public String toString() {
        return "Node{" +
                "name=" + name +
                '}';
    }
}

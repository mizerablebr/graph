import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Edge {
    private Node start;
    private Node end;

    public Edge(Node start, Node end) {
        this.start = start;
        this.end = end;
    }

    public Node getStart() {
        return start;
    }

    public Node getEnd() {
        return end;
    }

    public List<Node> getNodes() {
        return Arrays.asList(getStart(), getEnd());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Edge)) return false;
        Edge edge = (Edge) o;
        return Objects.equals(getStart(), edge.getStart()) &&
                Objects.equals(getEnd(), edge.getEnd()) ||
                Objects.equals(getStart(), edge.getEnd()) &&
                        Objects.equals(getEnd(), edge.getStart());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getStart().getName() + getEnd().getName());
    }
}

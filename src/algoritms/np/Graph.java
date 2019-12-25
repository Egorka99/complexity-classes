package algoritms.np;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    public Graph() {
        g = new ArrayList<>();
    }

    private List<Node> g;
    public void addNode(String personName) {
        Node node = new Node(personName);
        g.add(node);
    }
    public void addEdge(String personName1,String personName2) {
        Node node1 = null;
        Node node2 = null;
        for (Node node: g) {
            if (node.name.equals(personName1)) node1 = node;
            else if (node.name.equals(personName2)) node2 = node;
        }
        if (node1 != null && node2 != null) {
            node1.friends.add(node2);
            node2.friends.add(node1);
        }
    }
    public List<Node> getUniverse() {
        return g;
    }
    public void print() {
        for (Node node: g) {
            node.print();
        }
    }
}

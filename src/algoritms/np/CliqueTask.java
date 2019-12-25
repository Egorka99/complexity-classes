package algoritms.np;

import java.util.*;

class Node{
    String name;
    List<Node> friends = new ArrayList<>();

    public Node(String name) {
        this.name = name;
    }

    public Node(String person, List<Node> friends) {
        this.name = person;
        this.friends = friends;
    }

    public void print() {
        System.out.print("Person " + this.name + "knows ");
        for (Node friend: friends) {
            System.out.print(friend.name + ",");
        }
        System.out.println();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return name.equals(node.name);
    }

}
class Graph {

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
public class CliqueTask {

    void print(List<Node> list) {
        System.out.print("[");
        for (Node p: list) {
            System.out.print(" ");
            System.out.print(p.name);
        }
        System.out.print(" ]" + '\n');
    }
    List<Node> union(List<Node> a, List<Node> b) {
        Set result = new HashSet();
        result.addAll(a);
        result.addAll(b);
        return new ArrayList<>(result);
    } 

    List<Node> intersection(List<Node> a, List<Node> b) {
        List<Node> list = new ArrayList<>();

        for (Node item : a) {
            if(b.contains(item)) {
                list.add(item);
            }
        }
        return list;
    }
    List<Node> difference(List<Node> a, List<Node> b) {
        Set<Node> difference = new HashSet<>();
        difference.addAll(a);
        difference.removeAll(b);

        return new ArrayList<>(difference);
    }
    void bronKerbosch(List<Node> R, List<Node> P,List<Node> X){
        if (P.isEmpty() && X.isEmpty()) {
            System.out.println("Clique Found: ");
            print(R);
        }
        for (Node v : P) {
            List<Node> singleton = new ArrayList<>();
            singleton.add(v);
            bronKerbosch(union(R,singleton),intersection(P,v.friends),intersection(X,v.friends));
            P = difference(P,singleton);
            X = union(X,singleton);
        }
    }

    public static void main(String[] args) {

        Graph g = new Graph();
        String[] people = { "Amy", "Jack", "Erin", "Sally", "Sue", "Max", "Jake", "Tom", "Lu", "Joe", "Ryan", "Jess", "Liz", "Ty", "Jay"};
        for(String p : people) {
            g.addNode(p);
        }
        g.addEdge("Amy","Erin");
        g.addEdge("Amy","Jack");
        g.addEdge("Erin","Jack");
        g.addEdge("Erin","Sally");
        g.addEdge("Sally","Sue");
        g.addEdge("Sally","Max");
        g.addEdge("Max","Sue");
        g.addEdge("Sally","Tom");
        g.addEdge("Sally","Jake");
        g.addEdge("Tom","Jake");
        g.addEdge("Tom","Jess");
        g.addEdge("Tom","Lu");
        g.addEdge("Tom","Ryan");
        g.addEdge("Jess","Jake");
        g.addEdge("Jess","Lu");
        g.addEdge("Jess","Ryan");
        g.addEdge("Lu","Ryan");
        g.addEdge("Lu","Jake");
        g.addEdge("Lu","Joe");
        g.addEdge("Ryan","Jake");
        g.addEdge("Liz","Jay");
        g.addEdge("Liz","Ty");
        g.addEdge("Ty","Jay");

        List<Node> R = new ArrayList<>();
        List<Node> X = new ArrayList<>();
        List<Node> P = g.getUniverse();
        new CliqueTask().bronKerbosch(R,P,X);

        }
}

package algoritms.np;

import java.util.*;

public class CliqueTask {

    List<String> result = new ArrayList<>();

    public List<String> getResult() {
        return result;
    }

    void print(List<Node> list) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Node p: list) {
            sb.append(" ");
            sb.append(p.name);
        }
        sb.append(" ]" + '\n');
        result.add(sb.toString());
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
    public void bronKerbosch(List<Node> R, List<Node> P, List<Node> X){
        if (P.isEmpty() && X.isEmpty()) {
            result.add("Clique Found: ");
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

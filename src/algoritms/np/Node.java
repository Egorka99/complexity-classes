package algoritms.np;

import java.util.ArrayList;
import java.util.List;

public class Node{
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

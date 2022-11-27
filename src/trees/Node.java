package trees;

public class Node {
     Node p;
    int key;
    String name;
    Node lift;
    Node right;

    public Node(String name, int key){
        this.name = name;
        this.key = key;
    }

    @Override
    public String toString() {
        return name + " has Key: " + key;
    }
}

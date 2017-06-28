import static java.sql.Types.NULL;

/**
 * @project: BinarySearchTree
 * @author: liangb.dev
 * @version: 1.0
 * @date: 6/20/2017
 */
public class Node {
    private int data;
    private int depth;
    private Node parent;
    private Node leftChild;
    private Node rightChild;

    // Constructor default
    public Node() {
        this.data = -1;
        this.depth = -1;
        this.parent = null;
        this.leftChild = null;
        this.rightChild = null;
    }

    // Constructor w/ data
    public Node(int data) {
        this.data = data;
        this.depth = -1;
        this.parent = null;
        this.leftChild = null;
        this.rightChild = null;
    }

    // Constructor customized
    public Node(int data, int depth, Node parent, Node leftChild, Node rightChild) {
        setFields(data, depth, parent, leftChild, rightChild);
    }



    public void setFields(int data, int depth, Node parent, Node leftChild, Node rightChild) {
        this.data = data;
        this.depth = depth;
        this.parent = parent;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }
    public void setLeftChild(Node child) {
        if (child != null) {
            leftChild = child;
            child.depth = this.depth + 1;
            child.parent = this;
        }
    }
    public void setRightChild(Node child) {
        if (child != null) {
            rightChild = child;
            child.depth = this.depth + 1;
            child.parent = this;
        }
    }
    public void setParent(Node parent) {
        this.parent = parent;
    }
    public void setData(int data) {
        this.data = data;
    }
    public void setDepth(int depth) { this.depth = depth; }


    public int getData() { return this.data; }
    public Node getParent() {return this.parent; }
    public Node getLeftChild() {return this.leftChild; }
    public Node getRightChild() {return this.rightChild; }
    public int getdepth() { return this.depth; }

    public String printData() { return Integer.toString(this.data); }

}

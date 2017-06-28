import java.lang.reflect.Array;
import java.util.*;

/**
 * @project: BinarySearchTree
 * @author: liangb.dev
 * @version: 1.0
 * @date: 6/21/2017
 */
public class unbalancedBST implements IBST {

    // list of unsorted integers
    private ArrayList<Node> arr = new ArrayList<>();
    // queue to store Nodes for depth traversal
    private static Queue<Node> qq = new LinkedList<>();

    /**
     * Default Constructor
     * @param arrInt
     */
    public unbalancedBST(ArrayList<Integer> arrInt) {

        for (int i:arrInt) {
            arr.add(new Node(i));
        }

        arr.get(0).setDepth(0);

        buildBST();
    }


    /**
     * buildBST: builds child parent associations for nodes
     * args:
     * return:
     */
    public void buildBST() {
        for (int j=1; j<arr.size();j++) {
            setChildren(arr.get(j), arr.get(0));
        }
    }

    /**
     * setChildren: compares a parent Node and the candidate child Node
     * @param candidate the candidate child Node
     * @param parent the would-be parent Node
     */
    private void setChildren(Node candidate, Node parent) {
        // Case 1: root and next node has same data
        if (parent.getData() == candidate.getData()) {
            if (parent.getRightChild() == null) { // check null->else setParent conflict
                parent.setRightChild(candidate);
            } else {
                candidate.setRightChild(parent.getRightChild()); // insert next node
                parent.setRightChild(candidate);
            }
        }
        // Case 2: root's data is smaller than next node's data
        if (parent.getData() < candidate.getData()) {
            if (parent.getRightChild() == null) { // null can just be replaced
                parent.setRightChild(candidate);
            } else {
                setChildren(candidate, parent.getRightChild()); // compare to current rightChild
            }
        }
        // Case 3: root's data is larger than next node's data
        if (parent.getData() > candidate.getData()) {
            if (parent.getLeftChild() == null) { // null can just be replaced
                parent.setLeftChild(candidate);
            } else {
                setChildren(candidate, parent.getLeftChild()); // compare to current leftChild
            }
        }

    }

    /**
     * removeNode
     * @param m Node data field
     */
    public void removeNode(int m) {
        Node nd = this.arr.get(m);
        // if Node is last node
        if (m == arr.size()-1) {
            Node prev = this.arr.get(m-1);
            prev.setRightChild(null);
            prev.setLeftChild(null);
            arr.remove(m);
        }
        else if (m == 0) {
            Node next = this.arr.get(1);
            next.setParent(null);
        }
        else {
            Node prev = this.arr.get(m-1);
            Node next = this.arr.get(m+1);

            setChildren(prev, next);
        }

    }

    /**
     * BREADTH_FIRST_TRAVERSE: breadth-traversal of BST
     * qq: Static Queue, used to store nodes in-line to get visited.
     * CURRDEPTH: used to measure current depth that is being worked on.
     *         Once a node's current depth is surpassed, new print is used.
     *         (This variable is only for knowing when to newline\n in printing)
     */
    public void BREADTH_FIRST_TRAVERSE() {

        // Initial values
        qq.add(arr.get(0)); // add first node to queue
        int CURRDEPTH = 0; // current depth is 0

        // keep popping Queue until Queue is empty
        while (!qq.isEmpty()) {
            CURRDEPTH = breadthTraverseHelper(qq.remove(), CURRDEPTH);
        }

    }

    /**
     * breadthTraverseHelper(): adding Children Nodes to Queue when possible
     * @param parent Node whose children will be inspected (traversed)
     * @param CURRDEPTH current depth of traversal
     */
    private int breadthTraverseHelper(Node parent, int CURRDEPTH) {
        // print padding
        CURRDEPTH = breadthPrinter(parent, CURRDEPTH);

        // leftChild
        if (parent.getLeftChild() != null) {
            qq.add(parent.getLeftChild()); // add leftChild to queue
        }
        // rightChild
        if (parent.getRightChild() != null) {
            qq.add(parent.getRightChild()); // add rightChild to queue
        }

        return CURRDEPTH;
    }

    /**
     * breadthPrinter: printing newline and padding
     * @param parent
     * @param CURRDEPTH
     * @return =CURRDEPTH
     */
    private int breadthPrinter(Node parent, int CURRDEPTH) {
        // if new depth > curr depth
        if (parent.getdepth() > CURRDEPTH) {
            CURRDEPTH = parent.getdepth(); // curr depth = new depth
            System.out.print("\n");
        }

        System.out.print(parent.printData() + " ");

        return CURRDEPTH;
    }


    /**
     * PREORDER_DEPTH_TRAVERSE(): LEFT ROOT RIGHT traversal
     * STATE: originally a global variable, now passed down recursion and returned to top.
     *        Making it global would get rid of STATE as an argument, and the need for a return type.
     * Printing: Keeps track of nodes without children, using a static state. These
     *           signal a change of branch.
     *
     */
    public void PREORDER_DEPTH_TRAVERSE() {
        depthTraverseHelper(arr.get(0), false);
    }

    private boolean depthTraverseHelper(Node root, boolean STATE) {
        if (root != null) {
            //print branches
            STATE = depthPrinter(root, STATE);

            // branch traversal
            STATE = depthTraverseHelper(root.getLeftChild(), STATE);
            STATE = depthTraverseHelper(root.getRightChild(), STATE);
        }
        return STATE;
    }

    private boolean depthPrinter(Node root, boolean STATE) {
        // check if it's a new branch and needs padding
        if (STATE) {
            String result = "";
            for (int i = 0; i < root.getdepth() * 2; i++) {
                result += " ";
            }
            System.out.print(result);
            STATE = false;
        }

        // print node (after possible padding^)
        System.out.print(root.printData() + " ");

        // notify state that current node is end of branch, print newline
        if (root.getLeftChild() == null && root.getRightChild() == null) {
            System.out.print("\n");
            STATE = true;
        }
        return STATE;
    }


    public void printTree(String choice) {

        choice = choice.toLowerCase();
        if (choice.contains("depth")) {
            if (choice.contains("preorder")) {
                PREORDER_DEPTH_TRAVERSE();
            }
            else {
                PREORDER_DEPTH_TRAVERSE();
            }
        }
        if (choice.contains("breadth")) {
            BREADTH_FIRST_TRAVERSE();
        }
        else {
            System.out.print("Traversal type not recognized. ");
        }

    }


    public ArrayList<Node> getArr() { return this.arr; }



}

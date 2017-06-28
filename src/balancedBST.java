import java.util.ArrayList;

/**
 * @project: BinarySearchTree
 * @author: liangb.dev
 * @version: 1.0
 * @date: 6/25/2017
 */
public class balancedBST implements IBST {

    // list of unsorted integers
    private ArrayList<Node> arr = new ArrayList<>();

    /**
     * Default Constructor
     * @param arrInt takes in any array of integers
     */
    public balancedBST(ArrayList<Integer> arrInt) {

        for (int i: arrInt) {
            arr.add(new Node(i));
        }

        buildBST();
    }


    public void buildBST(){




    }

    public void setChildren(Node curr, Node prev) {

    }

    public void removeNode(int m) {

    }


}

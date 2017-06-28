import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @project: BinarySearchTree
 * @author: liangb.dev
 * @version: 1.0
 * @date: 6/21/2017
 */
class BSTTest {
    private String TRAV_TYPE = "breadth";

    @Test
    void buildBST() {
        ArrayList<Integer> arr = new ArrayList<>();

        arr.add(7);
        arr.add(9);
        arr.add(3);
        arr.add(11);
        arr.add(10);
        arr.add(15);
        arr.add(4);
        arr.add(4);
        arr.add(1);

        unbalancedBST unbalancedBst = new unbalancedBST(arr);
        Node root = unbalancedBst.getArr().get(0);

        // Test child/parent
        // 7 is the root
        assertEquals(9, root.getRightChild().getData());
        assertEquals(7, root.getRightChild().getParent().getData()); // parent
        assertEquals(3, root.getLeftChild().getData());
        assertEquals(7, root.getLeftChild().getParent().getData()); // parent
        assertEquals(11, root.getRightChild().getRightChild().getData());
        assertEquals(9, root.getRightChild().getRightChild().getParent().getData()); // parent
        assertEquals(15, root.getRightChild().getRightChild().getRightChild().getData());
        assertEquals(11, root.getRightChild().getRightChild().getRightChild().getParent().getData()); //p
        assertEquals(10, root.getRightChild().getRightChild().getLeftChild().getData());
        assertEquals(11, root.getRightChild().getRightChild().getLeftChild().getParent().getData()); //p
        assertEquals(4, root.getLeftChild().getRightChild().getData());
        assertEquals(3, root.getLeftChild().getRightChild().getParent().getData()); // parent
        assertEquals(4, root.getLeftChild().getRightChild().getRightChild().getData());
        assertEquals(4, root.getLeftChild().getRightChild().getRightChild().getParent().getData()); // p
        assertEquals(1, root.getLeftChild().getLeftChild().getData());
        assertEquals(3, root.getLeftChild().getLeftChild().getParent().getData()); // parent

        // test depth
        assertEquals(0, root.getdepth());
        assertEquals(1, root.getRightChild().getdepth());
        assertEquals(1, root.getLeftChild().getdepth());
        assertEquals(2, root.getLeftChild().getRightChild().getdepth());
        assertEquals(2, root.getLeftChild().getLeftChild().getdepth());
        assertEquals(3, root.getLeftChild().getRightChild().getRightChild().getdepth());
        assertEquals(2, root.getRightChild().getRightChild().getdepth());
        assertEquals(3, root.getRightChild().getRightChild().getRightChild().getdepth());
        assertEquals(3, root.getRightChild().getRightChild().getLeftChild().getdepth());

        unbalancedBst.printTree(TRAV_TYPE);
    }

    
    @Test
    public void buildBST1() {
        ArrayList<Integer> arr = new ArrayList<>();

        arr.add(6);
        arr.add(10);
        arr.add(4);
        arr.add(3);
        arr.add(8);
        arr.add(9);
        arr.add(15);

        unbalancedBST unbalancedBst = new unbalancedBST(arr);
        Node root = unbalancedBst.getArr().get(0);

        unbalancedBst.printTree(TRAV_TYPE);

    }

}
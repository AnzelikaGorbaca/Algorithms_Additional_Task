package traversing;

public class BinaryTree {

    // function to insert elements in Binary tree,
    // since Binary tree can have nodes with 1, 2 or 0 nodes, function inserts values to keep it sorted
    //if new element is smaller than nodes value it goes to the left child and if larger - to the right
    public void insert(Node node, int element) {

        if (element < node.key) { //if element is smaller than node, go to the left child of the node and repeat insertion
            if (node.left != null) {
                insert(node.left, element);
            } else {
                node.left = new Node(element); // add element if to element in the left child
            }
        } else if (element > node.key) {
            if (node.right != null) {
                insert(node.right, element);
            } else {
                node.right = new Node(element);
            }
        }
    }
}

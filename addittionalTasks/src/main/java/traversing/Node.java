package traversing;
/**
 * Node class containing right and left child and key
 *
 * **/

public class Node {
    int key;
    Node left;
    Node right;

    public Node(int value)
    {
        key = value;
        left = right = null;
    }
}


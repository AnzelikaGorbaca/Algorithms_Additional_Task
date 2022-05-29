package binary_search_tree;

import java.util.Arrays;
import java.util.List;

/**
 *  Binary search tree implementation:
 *  Operations:
 *  Insert a new element
 *  Delete an element
 *  Find an element in the tree
 *  Print Binary search tree
 *
 */

public class BinarySearchTree {

    // Define Root
    private Node root;

    BinarySearchTree() {
        root = null;
    }

    private  void insert(int key) {
        root = insertRec(root, key);
    }

    // A recursive function to insert a new element
    private Node insertRec(Node root, int element) {

        //Create a new node with new element if root is empty
        if (root == null) {
            root = new Node(element);
            return root;
        }

        //insert new element recursively depending if it is bigger then root or smaller
        if (element < root.key)
            root.left = insertRec(root.left, element);
        else if (element > root.key)
            root.right = insertRec(root.right, element);

        //set root
        return root;
    }

    //Functions to delete element
    void deleteElement(int element) {
        root = deleteElement(root, element);
    }

    //delete element from tree recursively
    private Node deleteElement(Node root, int element)
    {
        // Check if tree is empty
        if (root == null){
            return root;
        }

        //If tree is not empty start to search element, until it is the same as root
        if (element < root.key) {
            root.left = deleteElement(root.left, element);
        }
        else if (element > root.key) {
            root.right = deleteElement(root.right, element);
        }

        //Check if element is the same as root, if so this is the element to be deleted
        else {
            // Check if element is with one child or no childs and base of that choose new root element
            if (root.left == null) {
                return root.right;
            }
            else if (root.right == null) {
                return root.left;
            }

            //case if node has 2 children, find the smallest in the right subtree of the node and set it as root key
            root.key = smallestValue(root.right);

            // Delete the smallest and place instead of deleted element
            root.right = deleteElement(root.right, root.key);
        }
        return root;
    }

    int smallestValue(Node root)
    {
        int smallest = root.key; //define min value as root key
        while (root.left != null) //search for the smallest element - last child (left side)
        {
            smallest = root.left.key; //define root left element key as the smallest
            root = root.left; // define new root as the smallest node
        }
        return smallest;
    }

    //Functions to print Binary search tree
    private void displayPreorder() {
        displayPreorder(root);
    }

    private void displayPreorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.key + " ");
        displayPreorder(root.left);
        displayPreorder(root.right);
    }

    private void displayInorder() {
        displayInorder(root);
    }

    //recursive function to print inorder Binary Search tree
    private void displayInorder(Node root) {
        if (root != null) {
            displayInorder(root.left);
            System.out.print(root.key + " ");
            displayInorder(root.right);
        }
    }



    // Main class
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        // Insert elements into Binary search tree
        //define elements to insert
        List <Integer> insert = Arrays.asList(20,100,5,15,80,6,1,90,4,50);
        //insert elements
        for (int i : insert) {
            tree.insert(i);
        }

        // print Binary Search tree preorder (Root, Left, Right)
        System.out.println("Binary search tree values preorder:");
        tree.displayPreorder();
        System.out.println("\n");

        // print inorder traversal of the Binary Search tree
        System.out.println("Inorder Binary search tree values:");
        tree.displayInorder();


        //Delete elements
        //Define elements to delete

        //delete first element - root
        int firstTodelete = 20;
        tree.deleteElement(20);
        System.out.println("\n\nBinary search tree after deleting element " + firstTodelete);
        tree.displayPreorder();

        //delete node element with no child
        int secondToDelete = 90;
        tree.deleteElement(90);
        System.out.println("\n\nBinary search tree after deleting element " + secondToDelete);
        tree.displayPreorder();

    }



}


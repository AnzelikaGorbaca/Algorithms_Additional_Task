package traversing;

import binary_search_tree.BinarySearchTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Program to create and traverse Binary tree
 * Functions:
 * Insert values in Binary
 * Traverse Binary tree:
 * Inorder => Left, Root, Right.
 * <p>
 * Preorder => Root, Left, Right.
 * <p>
 * Post order => Left, Right, Root.
 **/

public class Traversing {

    //function that traverses tree in Post order and prints result (Left, Root, Right)
    public void traverseInOrder(Node node) {
        if (node != null) {
            traverseInOrder(node.left);
            System.out.print(" " + node.key);
            traverseInOrder(node.right);
        }
    }

    //function that traverses tree in Post order and prints result (Root, Left, Right)
    public void traversePreOrder(Node node) {
        if (node != null) {
            System.out.print(" " + node.key);
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }

    //function that traverses tree in Post order and prints result (Left, Right, Root)
    public void traversePostOrder(Node node) {
        if (node != null) {
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            System.out.print(" " + node.key);
        }
    }

    //Function that inserts elements in Binary tree
    public BinaryTree buildTree (List<Integer> elements, Node root){
        BinaryTree tree = new BinaryTree();
        for (int i : elements) {
           tree.insert(root, i);
        }
        return tree;
    }

    public void printMenu (){
        System.out.println(" 1 - INORDER");
        System.out.println (" 2 - PREORDER");
        System.out.println (" 3 - POSTORDER");
    }

    public static void main(String[] args) {
        //Build Binary Tree
        //define elements to insert
//        List<Integer> insertList = Arrays.asList(20,100,5,15,80,6,1,90,4,50);

        //Introduce menu to choose traversing
        Scanner scan = new Scanner(System.in);
        List<Integer> insertList = new ArrayList();

        System.out.println("\nHow many elements will be in the Binary Tree?");
        int size = scan.nextInt();

        System.out.println("Enter elements to insert in Binary Tree, type Stop to stop adding");
        //read user input and store in list
        while (size > 0) {
            insertList.add(scan.nextInt());
            size--;
        }

        //choose 1st element as root
        Node root = new Node(insertList.get(0));
        //Build Binary Tree
        Traversing traversing = new Traversing();
        traversing.buildTree(insertList,root);

        System.out.println("\nPlease Enter Your Choice From The Menu Below \nTo Choose Which Order The Tree Needs To Be Traversed\n ");
        traversing.printMenu();


        while (scan.hasNextInt()) {
            int number = scan.nextInt();
            switch (number) {
                case 1:
                    System.out.println("\nBinary tree traverse INORDER:");
                    traversing.traverseInOrder(root);
                    System.out.println("\n\nChoose other option or type exit");
                    traversing.printMenu();
                    break;
                case 2:
                    System.out.println("\nBinary tree traverse PREORDER:");
                    traversing.traversePreOrder(root);
                    System.out.println("\n\nChoose other option or type exit");
                    traversing.printMenu();
                    break;
                case 3:
                    System.out.println("\nBinary tree traverse POSTORDER:");
                    traversing.traversePostOrder(root);
                    System.out.println("\n\nChoose other option or type exit");
                    traversing.printMenu();
                    break;
                default:
                    System.out.println("Invalid choice! Please enter number defined in menu!");
                    System.out.println("\nChoose other option or type exit");
                    traversing.printMenu();

            }
        }
    }

}

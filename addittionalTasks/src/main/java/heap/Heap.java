package heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Program that makes following operations with Max-heap:
 * Inserts values in heap
 * Deletes values in heap
 * Displays heap
 * **/
public class Heap {


    public void reorderHeap(ArrayList<Integer> heapList, int i) {
        int size = heapList.size();
        int largest = i; //define node as largest
        int left = 2 * i + 1; //find left children
        int right = 2 * i + 2; //find right children
        //check that left child exists and if it is a bigger that node
        if (left < size && heapList.get(left) > heapList.get(largest))
            //define left largest
            largest = left;
        //check that right child exists and compare it with left child
        if (right < size && heapList.get(right) > heapList.get(largest))
            //if right is larger than left set right as largest
            largest = right;

        //if largest element became one of the child swap it with node
        if (largest != i) {
            int temp = heapList.get(largest);
            heapList.set(largest, heapList.get(i));
            heapList.set(i, temp);

            //check if heap has to be reordered after swapped node comparing it with children
            reorderHeap(heapList, largest);
        }
    }

    public void insert(ArrayList<Integer> heapList, int element) {
        boolean isEmpty = heapList.isEmpty(); //check if heap is empty before insertion
        heapList.add(element);

        if (!isEmpty) { //if heap was not empty before insertion, reorder heap
            reorder(heapList, heapList.size());
        }
    }

    public void deleteNode(ArrayList<Integer> heap, int element) {
        int size = heap.size();
        int i; //define i as element index
        //find element to delete in heap
        for (i = 0; i < size; i++) {
            if (element == heap.get(i))
                break;
        }

        //swap element to delete with the last element
        int temp = heap.get(i);
        heap.set(i, heap.get(size - 1));
        heap.set(size - 1, temp);

        //delete last element (element to delete)
        heap.remove(size - 1);
        //reorder heap after element deletion
        reorder(heap, size);
    }

    private void reorder(ArrayList<Integer> heapList, int size) {
        for (int i = size / 2 - 1; i >= 0; i--) { //continue reordering based of how many nodes are in heap
            reorderHeap(heapList, i);
        }
    }

   public void displayHeap(ArrayList<Integer> heapList) {
       System.out.println(heapList.toString().replace("[", "").replace("]",""));

   }

    public static void main(String args[]) {
        List<Integer> elementToInsert = Arrays.asList(10,100,2,5,11,1,30);

        //declare Heap and heaplist where to store elements
        Heap heap = new Heap();
        ArrayList<Integer> heapList = new ArrayList<>();

        //Insert elements into heap
        for (int i : elementToInsert){
            heap.insert(heapList, i);
        }

        //print heap
        System.out.println("Max-Heap with inserted values:");
        heap.displayHeap (heapList);

        //delete element from the heap
        heap.deleteNode(heapList, 100);
        System.out.println("\nHeap after deleting an element:");
        heap.displayHeap (heapList);
    }
}
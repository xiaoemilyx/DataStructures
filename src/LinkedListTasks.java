import java.util.HashSet;

public class LinkedListTasks {

    // Task 1: Build a linked list from an array
    public static SinglyLinkedList<Integer> buildList(int[] values) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

        for (int value : values) {
            list.insertAtEnd(new Node<Integer>(value));
        }

        return list;
    }

    // Task 2: Print the list in reverse without changing it
    public static void reversePrint(SinglyLinkedList<Integer> list) {
        printReverse(list.getHead());
        System.out.println();
    }

    private static void printReverse(Node<Integer> node) {
        if (node == null) {
            return;
        }

        printReverse(node.getNext());
        System.out.print(node.getData() + " ");
    }

    // Task 3: Remove duplicates, keeping the first occurrence
    public static void removeDuplicates(SinglyLinkedList<Integer> list) {
        HashSet<Integer> seen = new HashSet<>();

        int position = 0;
        Node<Integer> current = list.getHead();

        while (current != null) {
            Node<Integer> next = current.getNext();

            if (seen.contains(current.getData())) {
                list.remove(position);
            } else {
                seen.add(current.getData());
                position++;
            }

            current = next;
        }
    }
}


public class SinglyLinkedList<E> {

    // Head of the linked list
    Node<E> head;

    // Length of the linked list
    private int length = 0;

    // Default constructor
    public SinglyLinkedList() {
        length = 0;
    }

    // Return the first node in the list
    public synchronized Node<E> getHead() {
        return head;
    }

    // Insert a node at the beginning of the list
    public synchronized void insertAtBegin(Node<E> node) {
        node.setNext(head);
        head = node;
        length++;
    }

    // Insert a node at the end of the list
    public synchronized void insertAtEnd(Node<E> node) {
        if (head == null) {
            head = node;
        } else {
            Node<E> p = head;

            while (p.getNext() != null) {
                p = p.getNext();
            }

            p.setNext(node);
        }

        length++;
    }

    // Add a new value to the list at a given position
    public void insert(int data, int position) {
        if (position < 0) {
            position = 0;
        }

        if (position > length) {
            position = length;
        }

        if (head == null) {
            head = new Node<>((E) Integer.valueOf(data));
        } else if (position == 0) {
            Node<E> temp = new Node<>((E) Integer.valueOf(data));
            temp.setNext(head);
            head = temp;
        } else {
            Node<E> temp = head;

            for (int i = 1; i < position; i++) {
                temp = temp.getNext();
            }

            Node<E> newNode = new Node<>((E) Integer.valueOf(data));
            newNode.setNext(temp.getNext());
            temp.setNext(newNode);
        }

        length++;
    }

    // Remove and return the node at the beginning
    public synchronized Node<E> removeFromBegin() {
        Node<E> node = head;

        if (node != null) {
            head = node.getNext();
            node.setNext(null);
            length--;
        }

        return node;
    }

    // Return the last node in the list
    public synchronized Node<E> getLast() {
        if (head == null) {
            return null;
        }

        Node<E> p = head;

        while (p.getNext() != null) {
            p = p.getNext();
        }

        return p;
    }

    // Remove and return the last node in the list
    public synchronized Node<E> removeFromEnd() {
        if (head == null) {
            return null;
        }

        Node<E> p = head;
        Node<E> q = null;

        if (head.getNext() == null) {
            head = null;
            length--;
            return p;
        }

        while (p.getNext() != null) {
            q = p;
            p = p.getNext();
        }

        q.setNext(null);
        length--;

        return p;
    }

    // Remove a matching node from the list
    public synchronized void removeMatched(Node<E> node) {
        if (head == null) {
            return;
        }

        if (node.equals(head)) {
            head = head.getNext();
            length--;
            return;
        }

        Node<E> p = head;

        while (p.getNext() != null) {
            Node<E> q = p.getNext();

            if (node.equals(q)) {
                p.setNext(q.getNext());
                length--;
                return;
            }

            p = q;
        }
    }

    // Remove the value at a given position
    public void remove(int position) {
        if (position < 0) {
            position = 0;
        }

        if (position >= length) {
            position = length - 1;
        }

        if (head == null) {
            return;
        }

        if (position == 0) {
            head = head.getNext();
        } else {
            Node<E> temp = head;

            for (int i = 1; i < position; i++) {
                temp = temp.getNext();
            }

            temp.setNext(temp.getNext().getNext());
        }

        length--;
    }

    // Return a string representation of the list
    @Override
    public String toString() {
        String result = "[";

        if (head == null) {
            return result + "]";
        }

        result += head.getData();

        Node<E> temp = head.getNext();

        while (temp != null) {
            result += "," + temp.getData();
            temp = temp.getNext();
        }

        return result + "]";
    }

    // Return the current length of the list
    public int length() {
        return length;
    }

    // Find the position of the first matching value
    public int getPosition(int data) {
        Node<E> temp = head;
        int pos = 0;

        while (temp != null) {
            if (temp.getData().equals(data)) {
                return pos;
            }

            pos++;
            temp = temp.getNext();
        }

        return Integer.MIN_VALUE;
    }

    // Check whether the list is empty
    public boolean isEmpty() {
        return length == 0;
    }

    // Remove everything from the list
    public void clearList() {
        head = null;
        length = 0;
    }
}

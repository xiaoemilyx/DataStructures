import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

public class LinkedListTasksTest {

    @Test
    public void testBuildFromArray() {
        int[] values = {4, 2, 4, 3, 2, 4};

        // Implement buildList below, then use it here.
        SinglyLinkedList<Integer> numbers = LinkedListTasks.buildList(values);

        assertEquals(6, numbers.length());
        assertEquals("[4,2,4,3,2,4]", numbers.toString());
    }

    @Test
    public void testPrintReverse() {
        int[] values = {4, 2, 4, 3, 2, 4};
        SinglyLinkedList<Integer> numbers = LinkedListTasks.buildList(values);

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(output));

        try {
            // Implement reversePrint below.
            LinkedListTasks.reversePrint(numbers);
        } finally {
            System.setOut(originalOut);
        }

        assertEquals("4 2 3 4 2 4", output.toString().trim());
        assertEquals("[4,2,4,3,2,4]", numbers.toString());
    }

    @Test
    public void testRemoveDuplicates() {
        int[] values = {4, 2, 4, 3, 2, 4};
        SinglyLinkedList<Integer> numbers = LinkedListTasks.buildList(values);

        // Implement removeDuplicates below.
        LinkedListTasks.removeDuplicates(numbers);

        assertEquals("[4,2,3]", numbers.toString());
    }
}
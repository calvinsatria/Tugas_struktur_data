package id.umm.uts.ds;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AuditStackTest {

    private AuditStack<String> stack;

    @BeforeEach
    void setUp() {
        stack = new AuditStack<>();
    }

    @Test
    void addPlacesNewestElementAtTop() {
        stack.add("first");
        stack.validateInvariant();
        stack.add("second");
        stack.validateInvariant();

        assertEquals(2, stack.size());
        assertEquals("second", stack.peek());
    }

    @Test
    void removePopsLastAddedElementInLifoOrder() {
        stack.add("first");
        stack.add("second");
        stack.add("third");

        assertEquals("third", stack.remove(stack.size() - 1));
        stack.validateInvariant();
        assertEquals("second", stack.peek());
        assertEquals("second", stack.remove(stack.size() - 1));
        stack.validateInvariant();
        assertEquals("first", stack.peek());
    }

    @Test
    void onlyTopElementCanBeReadOrRemoved() {
        stack.add("first");
        stack.add("second");

        assertThrows(UnsupportedOperationException.class, () -> stack.get(0));
        assertThrows(UnsupportedOperationException.class, () -> stack.remove(0));
        stack.validateInvariant();
    }
}

package id.umm.uts.ds;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DynamicArrayTest {

    private DynamicArray<String> array;

    @BeforeEach
    void setUp() {
        array = new DynamicArray<>();
    }

    @Test
    void addIncreasesSize() {
        array.add("first");
        array.add("second");

        assertEquals(2, array.size());
        assertEquals("first", array.get(0));
        assertEquals("second", array.get(1));
        array.validateInvariant();
    }

    @Test
    void insertInMiddleShiftsElements() {
        array.add("first");
        array.add("third");

        array.insert(1, "second");

        assertEquals(3, array.size());
        assertEquals("first", array.get(0));
        assertEquals("second", array.get(1));
        assertEquals("third", array.get(2));
        array.validateInvariant();
    }

    @Test
    void removeAtBeginningMiddleAndEndPreservesInvariant() {
        array.add("zero");
        array.add("one");
        array.add("two");
        array.add("three");
        array.add("four");

        assertEquals("zero", array.remove(0));
        array.validateInvariant();
        assertEquals("two", array.remove(1));
        array.validateInvariant();
        assertEquals("four", array.remove(array.size() - 1));
        array.validateInvariant();

        assertEquals(2, array.size());
        assertEquals("one", array.get(0));
        assertEquals("three", array.get(1));
    }

    @Test
    void searchFindsValuesAndTracksComparisonSteps() {
        array.add("first");
        array.add("second");
        array.add("third");

        assertEquals(1, array.search("second"));
        assertEquals(2L, array.getLastSearchSteps());

        assertEquals(-1, array.search("missing"));
        assertEquals(3L, array.getLastSearchSteps());
    }

    @Test
    void invalidIndexesThrowIndexOutOfBoundsException() {
        assertThrows(IndexOutOfBoundsException.class, () -> array.get(0));
        assertThrows(IndexOutOfBoundsException.class, () -> array.insert(1, "value"));
    }
}

package JavaDataStructures.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.*;

public class SimpleList {

    private static final int INITIAL_CAPACITY = 10;
    private Object[] objects;
    private int size;

    public SimpleList() {
        objects = new Object[INITIAL_CAPACITY];
    }

    public void add(Object object) {
        objects[size++] = object;
    }

    public Object get(int index) {
        checkBounds(index);
        return objects[index];
    }

    public Object remove(int index) {
        Object object = get(index);
        for(int i = index; i < size - 1; i++) {
            objects[i] = objects[i + 1];
        }
        objects[--size] = null;
        return object;
    }

    public void forEach(Consumer consumer) {
        for(int i = 0; i < size; i++) {
            consumer.accept(objects[i]);
        }
    }

    public int size() {
        return size;
    }

    private void checkBounds(int index) {
        if(index < 0 || size <= index)  throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    public static void main(String[] args) {
        SimpleList list = new SimpleList();
        list.add("a");
        list.add("b");
        list.add("c");
        list.remove(2);
        list.add("d");

        list.forEach(System.out::println);
    }
}

class SimpleListTest {

    private SimpleList simpleList;

    @BeforeEach
    void setUp() {
        simpleList = new SimpleList();
    }

    @Test
    void shouldEmptyList() {
        assertEquals(0, simpleList.size());
    }

    @Test
    void shouldAddElements() {
        simpleList.add("a");
        simpleList.add("b");
        simpleList.add("c");

        assertEquals(3, simpleList.size());
        assertEquals("a", simpleList.get(0));
        assertEquals("b", simpleList.get(1));
        assertEquals("c", simpleList.get(2));

    }

    @Test
    void shouldRemoveElements() {
        simpleList.add("a");
        simpleList.add("b");

        assertEquals("a", simpleList.remove(0));
        assertNotEquals("a", simpleList.get(0));
    }

    @Test
    void shouldIterateElements() {
        simpleList.add("a");
        simpleList.add("b");
        simpleList.add("c");

        List<Object> collected = new ArrayList<>();
        simpleList.forEach(collected::add);

        assertEquals(3, collected.size());
        assertEquals("a", collected.get(0));
        assertEquals("b", collected.get(1));
        assertEquals("c", collected.get(2));


    }

    @Test
    void shouldThrowExceptionWhenIndexIsOutOfBounds() {
        simpleList.add("a");
        simpleList.add("b");

        Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> simpleList.get(2));
        assertEquals("Index: 2, Size: 2", exception.getMessage());

    }

}

package id.umm.uts.ds;

import java.util.Objects;

/** Generic dynamic array backed by a raw Object array. */
public class DynamicArray<T> implements StrukturData<T> {

    private static final int DEFAULT_CAPACITY = 10;

    private Object[] data;
    private int size;
    private long lastSearchSteps;

    public DynamicArray() {
        this(DEFAULT_CAPACITY);
    }

    public DynamicArray(int initialCapacity) {
        if (initialCapacity < 1) {
            throw new IllegalArgumentException("Kapasitas awal minimal 1");
        }
        data = new Object[initialCapacity];
    }

    @Override
    public void add(T value) {
        requireValue(value);
        ensureCapacity(size + 1);
        data[size++] = value;
        validateInvariant();
    }

    @Override
    @SuppressWarnings("unchecked")
    public T get(int position) {
        checkIndex(position);
        return (T) data[position];
    }

    @Override
    @SuppressWarnings("unchecked")
    public T remove(int position) {
        checkIndex(position);
        T removed = (T) data[position];
        int elementsToMove = size - position - 1;
        if (elementsToMove > 0) {
            System.arraycopy(data, position + 1, data, position, elementsToMove);
        }
        data[--size] = null;
        validateInvariant();
        return removed;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(T value) {
        return search(value) >= 0;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }
        size = 0;
        validateInvariant();
    }

    public void set(int position, T value) {
        requireValue(value);
        checkIndex(position);
        data[position] = value;
        validateInvariant();
    }

    public void insert(int position, T value) {
        requireValue(value);
        if (position < 0 || position > size) {
            throw new IndexOutOfBoundsException(
                    "Posisi " + position + " tidak valid untuk size " + size);
        }
        ensureCapacity(size + 1);
        System.arraycopy(data, position, data, position + 1, size - position);
        data[position] = value;
        size++;
        validateInvariant();
    }

    public int search(T value) {
        lastSearchSteps = 0;
        for (int i = 0; i < size; i++) {
            lastSearchSteps++;
            if (Objects.equals(data[i], value)) {
                return i;
            }
        }
        return -1;
    }

    public long getLastSearchSteps() {
        return lastSearchSteps;
    }

    private void ensureCapacity(int required) {
        if (required <= data.length) {
            return;
        }
        int doubledCapacity = data.length > Integer.MAX_VALUE / 2
                ? Integer.MAX_VALUE
                : data.length * 2;
        int newCapacity = Math.max(doubledCapacity, required);
        Object[] expanded = new Object[newCapacity];
        System.arraycopy(data, 0, expanded, 0, size);
        data = expanded;
    }

    private void checkIndex(int position) {
        if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException(
                    "Posisi " + position + " tidak valid untuk size " + size);
        }
    }

    private void requireValue(T value) {
        if (value == null) {
            throw new IllegalArgumentException("Nilai tidak boleh null");
        }
    }

    public void validateInvariant() {
        if (data == null) {
            throw new InvariantException("Array data null");
        }
        if (size < 0 || size > data.length) {
            throw new InvariantException("Size di luar kapasitas array");
        }
        for (int i = 0; i < size; i++) {
            if (data[i] == null) {
                throw new InvariantException("Elemen aktif null di indeks " + i);
            }
        }
        for (int i = size; i < data.length; i++) {
            if (data[i] != null) {
                throw new InvariantException("Slot kosong tidak null di indeks " + i);
            }
        }
    }
}

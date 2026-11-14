package id.umm.uts.ds;

/**
 * Stack (LIFO) generik — STRUKTUR SEKUNDER kelompok.
 * Digunakan untuk mencatat riwayat operasi pengguna (audit log).
 *
 * Tidak memakai java.util.Stack. Menggunakan array mentah.
 */
public class AuditStack<T> implements StrukturData<T> {

    private Object[] data;
    private int size;
    private int capacity;

    public AuditStack() {
        this.capacity = 10;
        this.data = new Object[capacity];
        this.size = 0;
    }

    /** Sama dengan push() di Stack standar. */
    @Override
    public void add(T value) {
        if (value == null) throw new IllegalArgumentException("Nilai tidak boleh null");
        if (size == capacity) {
            int newCapacity = capacity * 2;
            Object[] newData = new Object[newCapacity];
            System.arraycopy(data, 0, newData, 0, size);
            data = newData;
            capacity = newCapacity;
        }
        data[size] = value;
        size++;
        validateInvariant();
    }

    /** Mengambil elemen puncak tanpa menghapus (peek). */
    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) throw new IllegalStateException("Stack kosong");
        return (T) data[size - 1];
    }

    /** Membaca elemen dengan offset dari puncak tanpa mengubah stack. */
    @SuppressWarnings("unchecked")
    public T getFromTop(int offset) {
        if (offset < 0 || offset >= size) {
            throw new IndexOutOfBoundsException(
                    "Offset " + offset + " tidak valid untuk size " + size);
        }
        return (T) data[size - 1 - offset];
    }

    /**
     * Mengambil dan menghapus elemen puncak (pop).
     * Memetakan ke remove(size - 1) dari interface.
     */
    @Override
    @SuppressWarnings("unchecked")
    public T remove(int position) {
        if (isEmpty()) throw new IllegalStateException("Stack kosong");
        if (position != size - 1) {
            throw new UnsupportedOperationException("Stack hanya bisa menghapus dari puncak (LIFO)");
        }

        T removed = (T) data[size - 1];
        data[size - 1] = null;
        size--;
        validateInvariant();
        return removed;
    }

    /** Hanya elemen puncak yang dapat dibaca. */
    @Override
    public T get(int position) {
        if (position != size - 1) {
            throw new UnsupportedOperationException("Stack hanya bisa membaca elemen puncak");
        }
        return peek();
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
        if (value == null) return false;
        for (int i = 0; i < size; i++) {
            if (value.equals(data[i])) return true;
        }
        return false;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) data[i] = null;
        size = 0;
        validateInvariant();
    }

    public void validateInvariant() {
        if (data == null || capacity < 1 || data.length != capacity) {
            throw new InvariantException("Array atau kapasitas stack tidak valid");
        }
        if (size < 0) throw new InvariantException("Size negatif");
        if (size > capacity) throw new InvariantException("Size melebihi kapasitas");
        for (int i = 0; i < size; i++) {
            if (data[i] == null) throw new InvariantException("Elemen aktif null di indeks " + i);
        }
        for (int i = size; i < capacity; i++) {
            if (data[i] != null) throw new InvariantException("Slot nonaktif tidak null di indeks " + i);
        }
    }
}
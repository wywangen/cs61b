

public class ArrayDeque<T> {
    private T[] item;
    private int size;
    private int first;
    private int last;

    public ArrayDeque() {
        this.item = (T[]) new Object[8];
        this.size = 0;
        this.first = 0;
        this.last = 0;
    }

    private void resizing(int capacity) {
        T[] a = (T[]) new Object[capacity];
        if (first + size <= item.length) {
            System.arraycopy(item, first, a, 0, size);
        } else {
            System.arraycopy(item, first, a, 0, item.length - first);
            System.arraycopy(item, 0, a, item.length - first, size + first - item.length);
        }
        this.item = a;
    }


    public void addFirst(T x) {
        size += 1;
        if (size > item.length) {
            resizing(2 * size);
        }
        first = (first - 1);
        if (first < 0) {
            first = first + item.length;
        }
        item[first] = x;
    }


    public void addLast(T x) {
        size += 1;
        if (size > item.length) {
            resizing(2 * size);
        }
        last = (last + 1) % (item.length);
        if (last > item.length - 1) {
            last = last - item.length;
        }
        item[last] = x;
    }


    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else return false;
    }

    public int size() {
        return size;
    }


    public void printDeque() {
        for (int i = first; i < first + size; i++) {
            System.out.println(item[i % item.length] + " ");
        }
    }


    public T removeFirst() {
        if (size == 0) return null;
        else {
            T x = item[first];
            size = size - 1;
            first = (first + 1) % item.length;
            if ((double) size < (double) item.length / 4) {
                resizing(item.length / 2);
                first = 0;
                last = size - 1;
            }
            return x;
        }
    }


    public T removeLast() {
        if (size == 0) return null;
        else {
            T x = item[last];
            size = size - 1;
            last = last - 1;
            if (last < 0) {
                last = last + item.length;
            }
            if ((double) size < (double) item.length / 4) {
                resizing(item.length / 2);
                first = 0;
                last = size - 1;
            }
            return x;
        }
    }


    public T get(int index) {
        return item[(first + index) % item.length];
    }


}

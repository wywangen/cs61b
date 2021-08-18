

public class ArrayDeque<T> {
    private T[] item;
    private int size;
    private Integer first;
    private Integer last;

    public ArrayDeque() {
        this.item = (T[]) new Object[8];
        this.size = 0;
        this.first = null;
        this.last = null;
    }

    private void resizing(int capacity) {
        T[] a = (T[]) new Object[capacity];
        if (size == 0) {
            item = a;
            first = null;
            last = null;

        } else {
            if (first + size <= item.length) {
                System.arraycopy(item, first, a, 0, size);
            } else {
                System.arraycopy(item, first, a, 0, item.length - first);
                System.arraycopy(item, 0, a, item.length - first, size + first - item.length);
            }
            item = a;
            first = 0;
            last = size - 1;
        }


    }


    public void addFirst(T x) {
        if (size + 1 > item.length) {
            resizing(2 * item.length);
            first = item.length - 1;
            item[first]=x;
            size=size+1;
        } else {
            if (size == 0) {
                first = 0;
                last = 0;
                item[0] = x;
                size = 1;
            } else {
                first = first - 1;
                if (first < 0) {
                    first = first + item.length;
                }
                item[first] = x;
                size += 1;
            }

        }
    }


    public void addLast(T x) {

        if (size + 1 > item.length) {
            resizing(2 * item.length);
            last = size;
            item[last]=x;
            size=size+1;
        } else {
            if (size == 0) {
                first = 0;
                last = 0;
                size = 1;
                item[last] = x;
            } else {
                last = (last + 1) % item.length;
                item[last] = x;
                size += 1;
            }
        }

    }


    public boolean isEmpty() {
        return (size == 0);
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
        if (size == 0) {
            return null;
        } else {
            T x = item[first];
            size = size - 1;
            if (size == 0) {
                first = null;
                last = null;
                return x;
            } else {
                first = (first + 1) % item.length;
                while ((double) size < (double) item.length / 4  && item.length>16) {
                    resizing(item.length / 2);
                    first = 0;
                    last = size - 1;
                }

                return x;
            }

        }
    }


    public T removeLast() {
        if (size == 0) {
            return null;
        } else {
            T x = item[last];
            size = size - 1;
            if (size == 0) {
                first = null;
                last = null;
                return x;
            } else {
                last = last - 1;
                if (last < 0) {
                    last = last + item.length;
                }
                while ((double) size < (double) item.length / 4&&item.length>16) {
                    resizing(item.length / 2);
                    first = 0;
                    last = size - 1;
                }

                return x;
            }
        }
    }


    public T get(int index) {
        if (index > size - 1) {
            return null;
        } else {
            return item[(first + index) % item.length];
        }
    }


}

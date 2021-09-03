/**
 * 这次写这个结构有一个很不明智的地方，就是把first指向第一个元素，last指向最后一个元素。即[first,last]
 * 这导致要表示一个空的链表是困难的，这里就用first,last等于null来解决，后面就要用很多if来排除特殊情况
 * 采取的方法就是用yjm说的用[first,last)来表示，即用first指向第一个元素，last指向最后的元素的后一位，
 * 这样就可以轻松写出空的链表如[0,0)。或者同老师说的(first,last)，也是同样的道理。可以参考yjm的解答。
 * * @param <T>
 */
public class ArrayDeque<T>implements Deque<T> {
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

    @Override
    public void addFirst(T x) {
        if (size + 1 > item.length) {
            resizing(2 * item.length);
            first = item.length - 1;
            item[first] = x;
            size = size + 1;
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

    @Override
    public void addLast(T x) {

        if (size + 1 > item.length) {
            resizing(2 * item.length);
            last = size;
            item[last] = x;
            size = size + 1;
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

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }
    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        for (int i = first; i < first + size; i++) {
            System.out.println(item[i % item.length] + " ");
        }

    }

    @Override
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
                while ((double) size < (double) item.length / 4 && item.length > 16) {
                    resizing(item.length / 2);
                    first = 0;
                    last = size - 1;
                }

                return x;
            }

        }
    }

    @Override
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
                while ((double) size < (double) item.length / 4 && item.length > 16) {
                    resizing(item.length / 2);
                    first = 0;
                    last = size - 1;
                }

                return x;
            }
        }
    }

    @Override
    public T get(int index) {
        if (index > size - 1) {
            return null;
        } else {
            return item[(first + index) % item.length];
        }
    }


}

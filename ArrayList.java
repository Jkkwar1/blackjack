import java.util.NoSuchElementException;

@SuppressWarnings("unchecked")
public class ArrayList<E> {

    E[] arr;
    int size;
    int firstIndex;

    public ArrayList() {
        arr = (E[]) new Object[16];
        size = 0;
        firstIndex = -1;
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return arr.length;
    }

    private void resizeArray(int newCapacity) {
        E[] newArr = (E[]) new Object[newCapacity];

        for (int i = 0; i < size; i++) {
            newArr[i] = arr[(firstIndex + i) % capacity()];
        }

        firstIndex = 0;
        arr = newArr;
    }

    private int calculateIndex(int index) {
        return (firstIndex + index) % capacity();
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size " + size);
        }
        return arr[calculateIndex(index)];
    }

    public void addFirst(E item) {
        if (size == arr.length) {
            resizeArray(size * 2);
        }
        firstIndex = (firstIndex - 1 + arr.length) % arr.length;
        arr[firstIndex] = item;
        size++;
    }

    public void addLast(E item) {
        if (size == arr.length) {
            resizeArray(size * 2);
        }
        int lastIndex = (firstIndex + size) % arr.length;
        if (lastIndex < 0) {
            lastIndex += arr.length;
        }
        arr[lastIndex] = item;
        size++;
    }

    public E removeFirst() {
        if (size == 0) {
            throw new NoSuchElementException("List is empty");
        }
        E removedItem = arr[firstIndex];
        firstIndex = (firstIndex + 1) % arr.length;
        size--;
        return removedItem;
    }

    public E removeLast() {
        if (size == 0) {
            throw new NoSuchElementException("List is empty");
        }
        int lastIndex = (firstIndex + size - 1) % arr.length;
        E removedItem = arr[lastIndex];
        size--;
        return removedItem;
    }
}

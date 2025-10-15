public class MyArrayList<E> implements MyList<E> {
    Object[] data;
    int size;

    private static final int DEFAULT_SIZE = 5;

    public MyArrayList() {
        this.data = new Object[DEFAULT_SIZE];
        this.size = 0;
    }

    public MyArrayList(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException();
        }

        this.data = new Object[initialCapacity];
        this.size = 0;
    }

    public MyArrayList (E[] arr) {
        if (arr == null) {
            this.data = new Object[DEFAULT_SIZE];
            this.size = 0;
            return;
        }

        this.data = arr;
        this.size = arr.length;
    }

    /**
     * Increase the capacity of underlying array if needed
     *
     * @param requiredCapacity minimum capacity after expanding
     */
    @Override
    public void expandCapacity(int requiredCapacity) {
        int currentCapacity = data.length;

        // if newCapacity = 0, use default size
        int newCapacity = DEFAULT_SIZE;

        if (currentCapacity > 0) {
            newCapacity = DEFAULT_SIZE + DEFAULT_SIZE;
        }

        if (newCapacity < requiredCapacity) {
            newCapacity = requiredCapacity;
        }

        Object[] newData = new Object[newCapacity];

        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }

        data = newData;
    }

    /**
     * Get the amount of elements array can hold
     *
     * @return number of elements that can be held
     */
    @Override
    public int getCapacity() {
        return data.length;
    }

    /**
     * Add an element at the specified index
     *
     * @param index   position to insert the element
     * @param element the element to insert
     */
    @Override
    public void insert(int index, E element) {
        if (size == data.length) {
            expandCapacity(size + 1);
        }

        if (index < 0 || index > data.length) {
            throw new IndexOutOfBoundsException();
        }

        data[index] = element;
    }

    /**
     * Add an element to the end of the list
     *
     * @param element the element to append
     */
    @Override
    public void append(E element) {
        if (size == data.length) {
            expandCapacity(size + 1);
        }

        data[size] = element;
    }

    /**
     * Add an element to the beginning of the list 
     *
     * @param element the element to prepend
     */
    @Override
    public void prepend(E element) {

    }

    /**
     * Get the element at the given index
     *
     * @param index the index at which to return the element
     * @return the element at the index
     */
    @Override
    public E get(int index) {
        return null;
    }

    /**
     * Replaces an element at the specified index with a new element and return
     * the original element
     *
     * @param index   the index at which to replace
     * @param element the element with which to replace
     * @return the original element
     */
    @Override
    public E set(int index, E element) {
        return null;
    }

    /**
     * Remove the element at the specified index and return the removed element
     *
     * @param index the index at which to remove the element
     * @return the removed element
     */
    @Override
    public E remove(int index) {
        return null;
    }

    /**
     * Get the number of elements in the list
     *
     * @return number of elements in the list
     */
    @Override
    public int size() {
        return 0;
    }

    /**
     * Rotate the list by numPositions number of positions to the right
     * 
     * @param numPositions the number of positions to rotate by
     */
    @Override
    public void rotate(int numPositions) {

    }

    /**
     * Find the element in the list and return its index
     * 
     * @param element the element to find
     * @return the index of the last occurrence of element (-1 if not found)
     */
    @Override
    public int find(E element) {
        return 0;
    }
}
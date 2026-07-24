package skeletal.impl;

public interface MyList<E> {
    int size();
    E get(int index);
    void add(E element);
    boolean contains(E element);
    boolean isEmpty();
}
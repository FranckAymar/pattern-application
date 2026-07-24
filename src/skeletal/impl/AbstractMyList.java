package skeletal.impl;

public abstract class AbstractMyList<E> implements MyList<E> {

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean contains(E element) {
        for (int i = 0; i < size(); i++) {
            if (get(i).equals(element)) {
                return true;
            }
        }
        return false;
    }
}
package Iterator;

public interface MyIterator<E> {
    boolean hasNext();
    void next();
    E currentItem();
}

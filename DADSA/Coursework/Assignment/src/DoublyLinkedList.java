
import java.util.Iterator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ryan
 * @param <T>
 */
public class DoublyLinkedList<T extends Items> implements Iterable<T> {

    private Node<T> header;
    private Node<T> trailer;
    private long size;
    private MergeSort mergeSort;
    private boolean sorted;

    public DoublyLinkedList() {
        size = 0;
        header = new Node(null, null, null);
        trailer = new Node(null, null, header);
        header.next = trailer;
        sorted = false;
        mergeSort = new MergeSort();
    }

    public void add(T item) {
        Node newN = new Node<>(item, trailer, trailer.prev);
        trailer.prev.next = newN;
        trailer.prev = newN;
        size++;
        sorted = false;
    }

    public void add(Node<T> node) {
        node.prev = trailer.prev;
        node.next = trailer;
        trailer.prev.next = node;
        trailer.prev = node;
        size++;
        sorted = false;
    }

    public void remove(T item) {
        Node<T> remove = search(item);
        remove.next.prev = remove.prev;
        remove.prev.next = remove.next;
        remove.prev = null;
        remove.next = null;
        size--;
    }

    public void removeFirst() {
        this.header.next = this.getFirst().next;
        this.header.next.prev = this.header;
        size--;
    }

    public void removeLast() {
        this.trailer.prev = this.getLast().prev;
        this.getLast().prev.next = this.trailer;
        size--;
    }

    public void clear() {
        header.next = trailer;
        trailer.prev = header;
        size = 0;
    }

    public Boolean isEmpty() {
        return size == 0;
    }

    public long size() {
        return size;
    }

    public T get(long id) {
        return search(id).element;
    }

    public T get(String desc) {
        return search(desc).element;
    }

    public Node<T> getFirst() {
        Node<T> first;
        if (size > 0) {
            first = header.next;
        } else {
            first = null;
        }
        return first;
    }

    public Node<T> getLast() {
        Node<T> last;
        if (size > 0) {
            last = trailer.prev;
        } else {
            last = null;
        }
        return last;
    }

    public Node<T> getHeader() {
        return header;
    }

    public Node<T> getTrailer() {
        return trailer;
    }

    private Node<T> search(long target) {
        Node<T> searcher = this.header.next;
        if (this.getFirst().element.getClass().getTypeName().equals("Item") ^ this.getFirst().element.getClass().getTypeName().equals("ItemSet") ^ this.getFirst().element.getClass().getTypeName().equals("Repo")) {
            iWhile:
            while (true) {
                if (!sorted) {
                    for (int i = 0; i < this.size; i++) {
                        if (searcher.element.getId() == target) {
                            break iWhile;
                        } else {
                            searcher = searcher.next;
                        }
                    }
                } else {
                    if (target > (this.header.next.element.getId() + this.trailer.prev.element.getId() / 2)) {
                        searcher = this.trailer.prev;
                        for (int i = 0; i < this.size/2; i++) {
                            if (searcher.element.getId() == target) {
                                break iWhile;
                            } else {
                                searcher = searcher.prev;
                            }
                        }
                    }else{
                        for (int i = 0; i <= this.size; i++) {
                        if (searcher.element.getId() == target) {
                            break iWhile;
                        } else {
                            searcher = searcher.next;
                        }
                    }
                    }
                }
            }
        } else {
            lWhile:
            while (true) {
                for (int i = 0; i < this.size; i++) {
                    if (searcher.element.equals(target)) {
                        break lWhile;
                    } else {
                        searcher = searcher.next;
                    }
                }
            }
        }
        return searcher;
    }

    private Node<T> search(String target) {
        Node<T> searcher = this.header.next;
        if (this.getFirst().element.getClass().getTypeName().equals("Item") ^ this.getFirst().element.getClass().getTypeName().equals("ItemSet") ^ this.getFirst().element.getClass().getTypeName().equals("Repo")) {
            iWhile:
            while (true) {
                for (int i = 0; i < this.size; i++) {
                    if (searcher.element.getDescription().equals(target)) {
                        break iWhile;
                    } else {
                        searcher = searcher.next;
                    }
                }
            }
        } else {
            sWhile:
            while (true) {
                for (int i = 0; i < this.size; i++) {
                    if (searcher.element.equals(target)) {
                        break sWhile;
                    } else {
                        searcher = searcher.next;
                    }
                }
            }
        }
        return searcher;
    }

    private Node<T> search(T target) {
        Node<T> searcher = this.header.next;
        fWhile:
        while (true) {
            for (int i = 0; i < this.size; i++) {
                if (searcher.element.equals(target)) {
                    break fWhile;
                } else {
                    searcher = searcher.next;
                }
            }
        }

        return searcher;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator<>(this);
    }

    public void sort() {
        DoublyLinkedList<T> sorted = mergeSort.sort(this);
        this.header.next = sorted.getFirst();
        this.trailer.prev = sorted.getLast();
        sorted.getFirst().prev = this.header;
        sorted.getLast().next = this.trailer;
        this.sorted = true;
    }
}

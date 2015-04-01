
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
public class LinkedListIterator<T extends Items> implements Iterator<T> {

  private DoublyLinkedList<T> list;
  private Node<T> currentNode;

  public LinkedListIterator(DoublyLinkedList list) {
    this.list = list;
    currentNode = list.getFirst();
  }

  @Override
  public boolean hasNext() {
    return !(currentNode == null);
  }

  @Override
  public T next() {
    Node temp = currentNode;
    if (!currentNode.equals(list.getLast())) {
      currentNode = currentNode.next;
    }
    else{
      currentNode = null;
    }
    return list.get(temp.element.getId());
  }

}

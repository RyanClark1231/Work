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
public class MergeSort<T extends Items> {

  public DoublyLinkedList<T> sort(DoublyLinkedList<T> list) {

    if (list.size() <= 1) {
      return list;
    }
    DoublyLinkedList<T> left = new DoublyLinkedList<>();
    DoublyLinkedList<T> right = new DoublyLinkedList<>();

    Node<T> currentNode = list.getFirst();

    long middle = list.size() / 2;
    for (int i = 0; i < middle; i++) {
      Node<T> temp = new Node(currentNode.element, currentNode.next, currentNode.prev);
      left.add(temp);
      currentNode = currentNode.next;
    }
    for (long i = 0; i <= middle; i++) {
      Node<T> temp;
      if (i == 0) {
        temp = new Node(currentNode.element, currentNode.next, right.getHeader());
        right.add(temp);
        currentNode = currentNode.next;
      } else if (list.size() != 2 && !(currentNode.element==null)) {
        temp = new Node(currentNode.element, currentNode.next, currentNode.prev);
        right.add(temp);
        currentNode = currentNode.next;
      }

    }
    left = sort(left);
    right = sort(right);

    return merge(left, right);
  }

  private DoublyLinkedList<T> merge(DoublyLinkedList<T> left, DoublyLinkedList<T> right) {
    DoublyLinkedList<T> sortedList = new DoublyLinkedList<>();
    while (!left.isEmpty() && !right.isEmpty()) {
      if (left.getFirst().element.getId() < right.getFirst().element.getId()) {
        sortedList.add(new Node(left.getFirst().element, left.getFirst().next, left.getFirst().prev));
        left.removeFirst();
      } else {
        sortedList.add(new Node<>(right.getFirst().element, right.getFirst().next, right.getFirst().prev));
        right.removeFirst();
      }
    }
    while (!left.isEmpty()) {
      sortedList.add(new Node<>(left.getFirst().element, left.getFirst().next, left.getFirst().prev));
      left.removeFirst();
    }
    while (!right.isEmpty()) {
      sortedList.add(new Node<>(right.getFirst().element, right.getFirst().next, right.getFirst().prev));
      right.removeFirst();
    }
    return sortedList;
  }
}

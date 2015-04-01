/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ryan
 */
public class Node<T extends Items> {

  T element;
  Node<T> next, prev;

  public Node(T element, Node next, Node prev) {
    this.element = element;
    this.next = next;
    this.prev = prev;
  }
}


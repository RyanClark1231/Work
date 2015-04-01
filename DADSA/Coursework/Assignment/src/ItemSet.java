
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ryan
 */
public class ItemSet implements Items{

  private DoublyLinkedList<Item> items;
  private int nItems;
  private double price;
  private String description;
  private long id; 

  public ItemSet(long id, double price, String description) {
    items = new DoublyLinkedList<>();
    this.id = id;
    this.nItems = 0;
    this.price = price;
    this.description = description;
  }

  public void addItem(Item item) {
    items.add(item);
    nItems++;
  }

  public void removeItem(long id) {
    try{
      items.remove(items.get(id));
    nItems--;
    }catch(java.lang.NullPointerException ex){
        
    }
    
  }
  
  public void removeItem(String desc) {
    items.remove(items.get(desc));
    nItems--;
  }

  public DoublyLinkedList<Item> getItems() {
    return items;
  }

  public void setItems(DoublyLinkedList<Item> items) {
    this.items = items;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public int getnItems() {
    return nItems;
  }

  public double getPrice() {
    return price;
  }

  public String getDescription() {
    return description;
  }
  
  public boolean containsItem(long id){
      boolean contains = false;
      for(Item item:items){
          if(item.getId() == id){
              contains = true;
              break;
          }
      }
      return contains;
  }
 
}

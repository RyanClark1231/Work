


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ryan
 */
public class Repo implements Items{
  private DoublyLinkedList<Item> items;
  private DoublyLinkedList<ItemSet> sets;
  private String name;
  private long id;

  public Repo(String name, long id) {
    this.name = name;
    items = new DoublyLinkedList<>();
    sets = new DoublyLinkedList<>();
    this.id = id;
  }
  
  public void addSet(ItemSet set){
    sets.add(set);
  }
  
  public void addItem(Item item){
    items.add(item);
  }
  
  public void removeSet(long id){
    sets.remove(sets.get(id));
  }
  
  public void removeItem(long id){
    items.remove(items.get(id));
  }

  public String getDescription() {
    return name;
  }
  
  public long getId(){
    return id;
  }

  public DoublyLinkedList<ItemSet> getItemSets() {
    return sets;
  }
  
  public DoublyLinkedList<Item> getItems() {
    return items;
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
  
  public boolean containsItemSet(long id){
      boolean contains = false;
      for(ItemSet set:sets){
          if(set.getId() == id){
              contains = true;
              break;
          }
      }
      return contains;
  }
  
}

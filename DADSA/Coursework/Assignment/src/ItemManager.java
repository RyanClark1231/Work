
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ryan
 */
public class ItemManager {

    private DoublyLinkedList<Item> items;
    private DoublyLinkedList<ItemSet> itemSets;

    public ItemManager() {
        items = new DoublyLinkedList<>();
        itemSets = new DoublyLinkedList<>();
    }

    public void addItem(long id, String desc, double price) {
        items.add(new Item(id, desc, price));
    }

    public void removeItem(long id) {
        items.remove(items.get(id));
    }

    public void soldItem(long id) {
        DoublyLinkedList<ItemSet> inSets = new DoublyLinkedList<>();
        for (ItemSet set : itemSets) {
            if (set.containsItem(id)) {

            }
        }
        items.remove(items.get(id));
    }

    public Item getItem(long id) {
        return items.get(id);
    }

    /*public void insert(long id, String desc, double price) {
     for (Item item : items) {
     if (item.getId() > id) {
     items.add(items.indexOf(item), new Item(id, desc, price));
     }
     }
     }*/
    public void addItemSet(long id, double price, String desc) {
        itemSets.add(new ItemSet(id, price, desc));
    }

    public void removeItemSet(long id) {
        for (Item item : getItemSet(id).getItems()) {
            removeItem(item.getId());
        }
        itemSets.remove(itemSets.get(id));
    }

    public void removeItemSet(String desc) {
        itemSets.remove(itemSets.get(desc));
    }

    public ItemSet getItemSet(long id) {
        return itemSets.get(id);
    }

    public ItemSet getItemSet(String desc) {
        return itemSets.get(desc);
    }

    public DoublyLinkedList<Item> getItems() {
        return items;
    }

    public DoublyLinkedList<ItemSet> getItemSets() {
        return itemSets;
    }

    public long size() {
        return items.size();
    }

    public void sortItems() {
        items.sort();
    }

    public void findAnother(Item find, long set) {
        DoublyLinkedList<Item> found = new DoublyLinkedList<>();
        String type = getType(find.getDescription());
        for (Item item : items) {
            if (getType(item.getDescription()).equals(type)) {
                found.add(item);
            }
        }

        boolean possible = true;
        Node start = found.getFirst();
        Node first;
        for (first = start; first != found.getTrailer(); first = first.next) {
            possible = true;
            for (Item item : getItemSet(set).getItems()) {
                if (first.element.getId() == item.getId()) {
                    possible = false;
                    break;
                }
            }
            if (possible) {
                getItemSet(set).addItem(getItem(first.element.getId()));
                break;
            }
        }
    }

    public String getType(String desc) {
        String type;
        if (desc.substring(desc.length() - 4, desc.length() - 1).matches("[0-9]+")) {
            type = desc.substring(0, desc.length() - 5);
        } else if (desc.substring(0, 4).matches("[0-9]{2} + th")) {
            type = desc.substring(5);
        } else {
            type = desc;
        }

        return type;
    }
}

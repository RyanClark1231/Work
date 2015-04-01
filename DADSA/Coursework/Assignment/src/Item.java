/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ryan
 */
public class Item implements Items{

  private String description;
  private double price;
  private long id;

  public Item(long id, String description, double price) {

    this.description = description;
    this.price = price;
    this.id = id;
  }

  public long getId() {
    return id;
  }

  public String getDescription() {
    return description;
  }

  public double getPrice() {
    return price;
  }


}

package files.cart;

import java.io.*;
import java.util.*;
import java.sql.*;

public class Item 
{ 
  private int id;
  private String name;
  private String imagePath;
  private String itemDescription;
  private double price;

 public Item()
 {

 }
 public Item(int id,String name,String imagePath,String itemDescription,double price)
 {
    this.id = id;
    this.name = name;
    this.imagePath = imagePath;
    this.itemDescription = itemDescription;
    this.price = price;
 }
 public void setId(final int id)
 {
     this.id = id;
 }
 public int getId()
 {
     return id;
 }

  public void setName(final String name)
 {
     this.name = name;
 }
 public String getName()
 {
     return name;
 }

  public void setImagePath(final String imagePath)
 {
     this.imagePath = imagePath;
 }
 public String getImagePath()
 {
     return imagePath;
 }

  public void setItemDescription(final String itemDescription)
 {
     this.itemDescription = itemDescription;
 }
 public String getItemDescription()
 {
     return itemDescription;
 }

  public void setPrice(final double price)
 {
     this.price = price;
 }
 public double getPrice()
 {
     return price;
 }

 public boolean equals(Object o)
 {
   return(id == ((Item)o).id);
 }

 public String toString()
 {
   return id + name + imagePath + itemDescription + price;
 } 
};
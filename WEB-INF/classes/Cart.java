package files.cart;

import  java.util.*;
import java.io.*;

public class Cart 
{
  private Vector cartItems;

  public Cart()
  {
      cartItems = new Vector();
  }  
  public void addCartItem(CartItem cartItem)
  {
      if(cartItems.contains(cartItem))
      {
          int index = cartItems.indexOf(cartItem);
          CartItem thisItem = (CartItem)cartItems.get(index);
          thisItem.setQuantity(thisItem.getQuantity()+1);
      } 
      else 
      {
          cartItems.addElement(cartItem);
      }
  }
  public void setCartItems(final Vector cartItems)
  {
      this.cartItems = cartItems;
  }
  public Vector getCartItems()
  {
      return cartItems;
  }
  public void removeCartItems(final CartItem cartItem)
  {
      cartItems.remove(cartItem);
  }
  public double getCartValue()
  {
      double value = 0;
      Enumeration en = cartItems.elements();
      while(en.hasMoreElements())
      {
          CartItem cartItem = (CartItem)en.nextElement();
          value = value+(cartItem.getItem().getPrice()*cartItem.getQuantity());
      }
      return value;
  }
};
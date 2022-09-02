package files.cart;

import java.io.*;

public class CartItem 
{
   private int Quantity;
   private Item item;
   private String cartItemId;

   public CartItem()
   {

   }
   public CartItem(String cartItemId,Item item,int Quantity)
   {
       this.cartItemId = cartItemId;
       this.item = item;
       this.Quantity = Quantity;
   }
   public void setQuantity(int Quantity)
   {
       this.Quantity = Quantity;
   }
   public int getQuantity()
   {
       return Quantity;
   }
   public void setItem(Item item)
   {
       this.item = item;
   }
   public Item getItem()
   {
       return item;
   }
   public void setCartItemId(String cartItemId)
   {
       this.cartItemId = cartItemId;
   }
   public String getCartItemId()
   {
       return cartItemId;
   }
   public boolean equals(Object o)
   {
       return ((CartItem)o).cartItemId.equals(cartItemId);
   }
};
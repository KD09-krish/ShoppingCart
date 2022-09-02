package files.cart;

import javax.sql.*;
import java.sql.*;
import java.io.*;
import java.util.*;
import javax.naming.*; 


public class ItemDao extends BaseDao
{
   public ItemDao()
   {

   }

   public Collection getAllItems() throws SQLException,ClassNotFoundException
   { 
      
      getConnection();
      Vector items = new Vector();
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("select * from items");
      while(rs.next())
      {
          Item item = new Item();// every iteration a new item should be formed
         
         item.setId(rs.getInt(1));//first column data
         item.setName(rs.getString(2));
         item.setImagePath(rs.getString(3));
         item.setItemDescription(rs.getString(4));
         item.setPrice(rs.getDouble(5));
         items.add(item);
      }
     // System.out.println(items+"--------------------------");
      stmt.close();
      closeConnection();
      
      return items;
      
   }

   public int getItemCount() throws SQLException,ClassNotFoundException
   {
      Connection con =  getConnection();
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("select count(*) from items");
      rs.next();
      int itemCount = rs.getInt(1);
      stmt.close();
      closeConnection();
      return itemCount;
   }

   public Item getItem(final int itemId) throws SQLException,ClassNotFoundException
   {
       Item item = new Item();
       Connection con = getConnection();
       Statement stmt = con.createStatement();
       ResultSet rs = stmt.executeQuery("select * from items where itemId = "+itemId);
       while(rs.next())
       {
          item.setId(rs.getInt(1));
          item.setName(rs.getString(2));
          item.setImagePath(rs.getString(3));
          item.setItemDescription(rs.getString(4));
          item.setPrice(rs.getDouble(5));
       }
       stmt.close();
       closeConnection();
       return item;
   }


   
};
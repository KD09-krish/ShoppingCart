package files.cart;

import java.servlet.*;
import java.servlet.http.*;
import java.io.*;
import java.sql.*;

public class FetchItemServlet extends HttpServlet 
{
  protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
  {
      response.setContentType("text/html");
      PrintWriter pw = response.getWriter();
      try
      {
       ItemDao item = new ItemDao();
       Collection items = item.getAllItems();
       request.setAttribute("items",items);
      }
      catch(Exception e)
      {
          System.out.println(e);
      }

  }
};
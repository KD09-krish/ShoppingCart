package files.cart;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.*;

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
       request.getRequestDispatcher("Cataloq.jsp").forward(request,response);
      }
      catch(Exception e)
      {
          System.out.println(e);
      }

  }
};
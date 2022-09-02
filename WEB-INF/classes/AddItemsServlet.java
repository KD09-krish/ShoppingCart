package files.cart;

import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;


public class AddItemsServlet extends HttpServlet 
{
   protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException 
   {
     response.setContentType("text/html");
     PrintWriter pw = response.getWriter();
     HttpSession session = request.getSession();
     ItemDao dao = new ItemDao();
     Cart cart = (Cart)session.getAttribute("cart");

     if(cart == null)
     {
       cart = new Cart();
       session.setAttribute("cart",cart);
     }

     try 
     { 
       int itemCount = dao.getItemCount();
       for(int i=1;i<=itemCount;i++)
       {
         String s = request.getParameter("item"+i);
         if(s!= null)// checkbox selected
         {
           Item item = dao.getItem(i);
           CartItem cartItem = new CartItem("cartItem"+item.getId(),item,1);
           cart.addCartItem(cartItem);
         }
       }
       response.sendRedirect("/Shop/DisplayCart.jsp"); 
     }
     catch(Exception e)
     {
        pw.println(e);
     }
   }
};
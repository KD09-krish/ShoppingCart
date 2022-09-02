package files.cart;

import javax.servlet.*;
import javax.servlet.jsp.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class DecisionServlet extends HttpServlet 
{

  protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException 
  {
      response.setContentType("text/html");
      PrintWriter pw = response.getWriter();
  // we are getting these parameters are we are clicking the button and we are checking if it
  // is null or not and then permforming the action on it.
      String shop = request.getParameter("shop");
      if(shop!= null)
      {
          request.getRequestDispatcher("/FetchItem").forward(request,response);
          // if we dont send the request to fetchItemsServlet then we wont be able to get the catalogue 
          // info if we directly send the request to catalog.jsp.
      }
      String freeze = request.getParameter("freeze");
      if(freeze!= null)
      {
        request.getRequestDispatcher("/FreezeCart.jsp").forward(request,response);
      }
      
      String update = request.getParameter("update");
      if(update!= null)
      {
        HttpSession session = request.getSession();
        Cart cart = (Cart)session.getAttribute("cart");
        Collection cartItems = cart.getCartItems();
        Iterator it = cartItems.iterator();
        Vector v = new Vector();

        while(it.hasNext())
        {
          CartItem cartItem = (CartItem)it.next();
          cartItem.setQuantity(Integer.parseInt(request.getParameter("T"+cartItem.getCartItemId())));
          
          if(request.getParameter(cartItem.getCartItemId())!= null)
            v.addElement(cartItem.getCartItemId());
        }
         
        Enumeration en = v.elements();
        while(en.hasMoreElements())
        {
          String cartItemId = (String)en.nextElement();
          CartItem cartItem = new CartItem(cartItemId,null,0);
          cart.removeCartItems(cartItem);
        }
        request.getRequestDispatcher("/DisplayCart.jsp").forward(request,response);
      }
  }

};
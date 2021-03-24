package com.book.web;

import com.book.pojo.Book;
import com.book.pojo.Cart;
import com.book.pojo.CartItem;
import com.book.service.impl.BookServiceImpl;
import com.book.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CartServlet extends BaseServlet {
    private BookServiceImpl bookService = new BookServiceImpl();


    /**
     * 清空购物车
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void clear(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart == null){
            cart = new Cart();
        }
        cart.clear();
        //保存到Session域中
        request.getSession().setAttribute("cart", cart);
        //重定向回原来的页面
        String referer = request.getHeader("Referer");
        response.sendRedirect(referer);
    }

    /**
     * 更改商品数量
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void updateCount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart == null){
            cart = new Cart();
        }
        int id = WebUtils.parseInt(request.getParameter("id")) ;
        int count = WebUtils.parseInt(request.getParameter("count")) ;
        request.getSession().setAttribute("count", 4);
        cart.updateCount(id , count);
        //保存到Session域中
        request.getSession().setAttribute("cart", cart);
        //重定向回原来的页面
        String referer = request.getHeader("Referer");
        response.sendRedirect(referer);
    }
    protected void deleteItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart == null){
            cart = new Cart();
        }
        int id = WebUtils.parseInt(request.getParameter("id")) ;
        cart.deleteItem(id);
        //保存到Session域中
        request.getSession().setAttribute("cart", cart);
        //重定向回原来的页面
        String referer = request.getHeader("Referer");
        response.sendRedirect(referer);
    }

    /**
     * 添加购物车页面数据
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void addItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = WebUtils.parseInt(request.getParameter("id"));

        //获取Cart对象
        Book book = bookService.queryBookById(id);
        CartItem cartItem = new CartItem(id, book.getName(), 1, book.getPrice(), book.getPrice());

        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart == null){
            cart = new Cart();
        }
        cart.addItem(cartItem);

        //保存到Session域中
        request.getSession().setAttribute("cart", cart);
        request.getSession().setAttribute("lastName", cartItem.getName());
        //重定向回原来的页面
        String referer = request.getHeader("Referer");
        response.sendRedirect(referer);

    }

}

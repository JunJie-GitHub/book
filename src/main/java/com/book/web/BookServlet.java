package com.book.web;

import com.book.pojo.Book;
import com.book.pojo.Page;
import com.book.service.BookService;
import com.book.service.impl.BookServiceImpl;
import com.book.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class BookServlet extends BaseServlet {
    private final BookService bookService = new BookServiceImpl();

    /**
     * 处理分页功能
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1, 获取请求参数 pageNo和pageSize
        int pageNo = WebUtils.strToInt(request.getParameter("pageNo"));

        int pageSize = WebUtils.strToInt(request.getParameter("pageSize"));

        //2, 调用BookService.page(pageNo, pageSize): Page对象
        Page<Book> page = bookService.page(pageNo, pageSize);
        page.setUrl("manager/bookServlet?action=page"); //设置url

        //3, 保存Page对象到Reuquest域中
        request.setAttribute("page", page);
        //4, 请求转发到pages/manager/book_manager.jsp页面
        request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);
    }

    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //用封装好的BeanUtils工具类, 把返回的参数注入到Book里
        Book book = WebUtils.copyParamToBean(request.getParameterMap(), new Book());
        bookService.addBook(book);
        //跳到图书列表页面
//       注意: 这样写是个bug, 用户刷新页面会导致表单重复提交
//        request.getRequestDispatcher("/manager/bookServlet?action=list").forward(request, response);
        response.sendRedirect(request.getContextPath()+"/manager/bookServlet?action=list");
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            bookService.deleteBookById(Integer.valueOf(request.getParameter("id")));
            response.sendRedirect(request.getContextPath()+"/manager/bookServlet?action=list");
    }

    protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> bookList = bookService.queryBooks();
        request.setAttribute("books", bookList);
        request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);
    }
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //用封装好的BeanUtils工具类, 把返回的参数注入到Book里
        Book book = WebUtils.copyParamToBean(request.getParameterMap(), new Book());
        bookService.updateBook(book);
        response.sendRedirect(request.getContextPath()+"/manager/bookServlet?action=list");
    }

    /**
     * 修改图书
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void getBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Book book = bookService.queryBookById(Integer.valueOf(request.getParameter("id")));
        request.setAttribute("book", book);
        request.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(request, response);
    }

}

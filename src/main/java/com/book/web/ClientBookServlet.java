package com.book.web;

import com.book.pojo.Book;
import com.book.pojo.Page;
import com.book.service.BookService;
import com.book.service.impl.BookServiceImpl;
import com.book.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ClientBookServlet extends BaseServlet{

    private final BookService bookService = new BookServiceImpl();

    protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1, 获取请求参数 pageNo和pageSize
        int pageNo = WebUtils.strToInt(request.getParameter("pageNo"));

        int pageSize = WebUtils.strToInt(request.getParameter("pageSize"));

        //2, 调用BookService.page(pageNo, pageSize): Page对象
        Page<Book> page = bookService.page(pageNo, pageSize);
        page.setUrl("client/bookServlet?action=page"); //设置url

        //3, 保存Page对象到Reuquest域中
        request.setAttribute("page", page);
        //4, 请求转发到pages/manager/book_manager.jsp页面
        request.getRequestDispatcher("/pages/client/index.jsp").forward(request, response);
    }

    /**
     * 处理指定价格区间分页
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void pageByPrice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);
        int min = WebUtils.parseInt(request.getParameter("min"), 0);
        int max = WebUtils.parseInt(request.getParameter("max"), Integer.MAX_VALUE);

        Page<Book> page = bookService.pageByPrice(pageNo, pageSize, min, max);

        //保存max, min参数, 让页条始终带用户输入的价格区间
        StringBuilder stringBuilder = new StringBuilder("client/bookServlet?action=pageByPrice");
        if (request.getParameter("min")!=null){
            stringBuilder.append("&min=").append(request.getParameter("min"));
        }
        if (request.getParameter("max")!=null){
            stringBuilder.append("&max=").append(request.getParameter("max"));
        }
        page.setUrl(stringBuilder.toString()); //设置url

        request.setAttribute("page", page);
        request.getRequestDispatcher("/pages/client/index.jsp").forward(request, response);
    }
}

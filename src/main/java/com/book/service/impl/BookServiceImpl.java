package com.book.service.impl;

import com.book.dao.BookDao;
import com.book.dao.impl.BookDaoImpl;
import com.book.pojo.Book;
import com.book.pojo.Page;
import com.book.service.BookService;
import com.book.utils.WebUtils;

import java.util.List;

/**
 * BookDaoImpl实现的是对数据库的操作,不能有其他代码,  BookServiceImpl可以有一些逻辑代码等
 */
public class BookServiceImpl implements BookService {
    private final BookDao bookDao = new BookDaoImpl();
    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public void deleteBookById(Integer id) {
        bookDao.deleteBookById(id);
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBooks();
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public Page<Book> page(int pageNo, int pageSize) {
        Page<Book> page = new Page<Book>();

        //设置每页显示数量
        pageSize = pageSize==0?Page.PAGE_SIZE : pageSize;
        page.setPageSize(pageSize);

        //求总记录数
        Integer pageTotalCount = bookDao.queryForPageTotalCount();
        page.setPageTotalCount(pageTotalCount);

        //求总页码
        Integer pageTotal = pageTotalCount/pageSize;
        page.setPageTotal(pageTotal);

        //设置当前页码

        page.setPageNo(pageNo);

        //求当前页数据
        int begin = (page.getPageNo()-1) * pageSize;    //当前页数据开始索引
        List<Book> items = bookDao.queryForPageItems(begin, pageSize);
        page.setItems(items);

        return page;
    }

    @Override
    public Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max) {
        Page<Book> page = new Page<Book>();

        //设置每页显示数量
        pageSize = pageSize==0?Page.PAGE_SIZE : pageSize;
        page.setPageSize(pageSize);

        //求总记录数
        Integer pageTotalCount = bookDao.queryForPageTotalCount(min, max);
        page.setPageTotalCount(pageTotalCount);

        //求总页码
        Integer pageTotal = pageTotalCount/pageSize;
        page.setPageTotal(pageTotal);

        //设置当前页码

        page.setPageNo(pageNo);

        //求当前页数据
        int begin = (page.getPageNo()-1) * pageSize;    //当前页数据开始索引
        List<Book> items = bookDao.queryForPageItemsByPrice(begin, pageSize, min, max);
        page.setItems(items);

        return page;
    }
}

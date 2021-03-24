package com.book.service;

import com.book.pojo.Book;
import com.book.pojo.Page;

import java.util.List;

/**
 * 这里的BookService直接复制了BookDao, 开发中Service里的方法名字可以更贴近功能实现, 易懂
 */
public interface BookService {
    /**
     * 增加图书
     * @param book
     * @return
     */
    void addBook(Book book);

    /**
     * 删除指定id的图书
     * @param id
     * @return
     */
    void deleteBookById(Integer id);

    /**
     * 根据id查询book
     * @param id
     * @return
     */
    Book queryBookById(Integer id);

    /**
     * 查询所有图书信息
     * @return
     */
    List<Book> queryBooks();

    /**
     * 根据id修改图书信息
     * @param book
     * @return
     */
    void updateBook(Book book);

    Page<Book> page(int pageNo, int pageSize);

    Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max);
}

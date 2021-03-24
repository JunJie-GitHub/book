package com.book.dao;

import com.book.pojo.Book;

import java.util.List;

public interface BookDao {

    /**
     * 增加图书
     * @param book
     * @return
     */
    int addBook(Book book);

    /**
     * 删除指定id的图书
     * @param id
     * @return
     */
    int deleteBookById(Integer id);

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
    int updateBook(Book book);

    Integer queryForPageTotalCount();

    List<Book> queryForPageItems(int begin, int pageSize);

    List<Book> queryForPageItemsByPrice(int begin, int pageSize, int min, int max);

    Integer queryForPageTotalCount(int min, int max);
}

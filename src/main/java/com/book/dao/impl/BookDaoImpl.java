package com.book.dao.impl;

import com.book.dao.BookDao;
import com.book.pojo.Book;
import java.util.List;

public class BookDaoImpl extends BaseDao implements BookDao {
    @Override
    public int addBook(Book book) {
        String sql = "INSERT INTO book VALUES(?, ?, ?, ?, ?, ?, ?)";
        return update(sql, book.getId(), book.getName(), book.getAuthor(),
                book.getPrice(), book.getSales(), book.getStock(), book.getImgPath());
    }

    @Override
    public int deleteBookById(Integer id) {
        String sql = "DELETE FROM book WHERE id = ?";
        return update(sql, id);
    }


    @Override
    public Book queryBookById(Integer id) {
        String sql = "SELECT * FROM book WHERE id = ?";
        return queryForOne(Book.class, sql, id);
    }

    @Override
    public List<Book> queryBooks() {
        String sql = "SELECT * FROM book";
        return queryForList(Book.class, sql);
    }

    @Override
    public int updateBook(Book book) {
        String sql = "UPDATE book SET name=?, author=?, price=?, " +
                "sales=?, stock=?, img_path=? WHERE id=?";
        return update(sql, book.getName(), book.getAuthor(), book.getPrice(),
                book.getSales(), book.getStock(), book.getImgPath(), book.getId());
    }

    @Override
    public Integer queryForPageTotalCount() {
        String sql = "SELECT COUNT(*) FROM book";
        Number count = (Number) queryForSingleValue(sql);
        return count.intValue();
//        return  Integer.valueOf(queryForSingleValue(sql).toString());   //返回的是Long类型
    }

    @Override
    public List<Book> queryForPageItems(int begin, int pageSize) {
        String sql = "SELECT * FROM book LIMIT ?, ?";
        return queryForList(Book.class, sql, begin, pageSize);
    }

    @Override
    public List<Book> queryForPageItemsByPrice(int begin, int pageSize, int min, int max) {
        String sql = "SELECT * FROM book WHERE price BETWEEN ? AND ? ORDER BY price LIMIT ?, ?";
        return queryForList(Book.class, sql, min, max, begin, pageSize);
    }

    @Override
    public Integer queryForPageTotalCount(int min, int max) {
        String sql = "SELECT COUNT(*) FROM book WHERE price BETWEEN ? AND ?";
        Number count = (Number) queryForSingleValue(sql, min, max);
        return count.intValue();
    }
}

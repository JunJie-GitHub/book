package com.book.dao.impl;

import com.book.dao.BookDao;
import com.book.pojo.Book;
import junit.framework.TestCase;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class BookDaoImplTest{
    BookDao bookDao = new BookDaoImpl();
    @Test
    public void addBook() {
//        bookDao.addBook(new Book(null, "文明2", BigDecimal.valueOf(34.00), 222, 1112, null));
        System.out.println(bookDao.addBook(new Book(null, "文明2", "Tom", BigDecimal.valueOf(34.00), 222, 1112, null)));
    }

    @Test
    public void deleteBookById() {
        System.out.println(bookDao.deleteBookById(3));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookDao.queryBookById(2));
    }

    @Test
    public void queryBooks() {
        List<Book> bookList = bookDao.queryBooks();
        for(Book book : bookList){
            System.out.println(book);
        }
    }
    @Test
    public void updateBook(){
        System.out.println(bookDao.updateBook(new Book(3, "安妮", "俊杰", BigDecimal.valueOf(57.00), 43, 432, null)));
    }

    @Test
    public void queryForPageTotalCount() {
        System.out.println(bookDao.queryForPageTotalCount());
    }

    @Test
    public void queryForPageItems() {
        List<Book> bookList = bookDao.queryForPageItems(1, 4);
        for(Book book : bookList){
            System.out.println(book);
        }
    }
}
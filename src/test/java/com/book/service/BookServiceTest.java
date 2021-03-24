package com.book.service;

import com.book.pojo.Book;
import com.book.pojo.Page;
import com.book.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class BookServiceTest {
    BookService bookService = new BookServiceImpl();
    @Test
    public void addBook() {
        bookService.addBook(new Book(null, "狐妖小红娘", "太美",
                BigDecimal.valueOf(64.00), 2663, 4323, null));
    }

    @Test
    public void deleteBookById() {
        bookService.deleteBookById(5);
    }

    @Test
    public void queryBookById() {
        System.out.println(bookService.queryBookById(4));
    }

    @Test
    public void queryBooks() {
        for(Book book : bookService.queryBooks()){
            System.out.println(book);
        }
    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(4, "狐妖小红娘", "太美",
                BigDecimal.valueOf(64.00), 3554, 2545, null));
    }

    @Test
    public void page(){
        Page<Book> page = bookService.page(1, 4);
        System.out.println(page);
    }
}
package com.book.pojo;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class CartTest {

    @Test
    public void addItem() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "jerry", 34, new BigDecimal(324), new BigDecimal(5435)));
        cart.addItem(new CartItem(1, "jerry", 34, new BigDecimal(324), new BigDecimal(5435)));
        cart.addItem(new CartItem(2, "Java精通", 34, new BigDecimal(324), new BigDecimal(5435)));
        System.out.println(cart);
    }

    @Test
    public void deleteItem() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "jerry", 34, new BigDecimal(324), new BigDecimal(5435)));
        cart.addItem(new CartItem(1, "jerry", 34, new BigDecimal(324), new BigDecimal(5435)));
        cart.addItem(new CartItem(2, "Java精通", 34, new BigDecimal(324), new BigDecimal(5435)));
        cart.deleteItem(1);
        System.out.println(cart);
    }

    @Test
    public void clear() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "jerry", 34, new BigDecimal(324), new BigDecimal(5435)));
        cart.addItem(new CartItem(1, "jerry", 34, new BigDecimal(324), new BigDecimal(5435)));
        cart.addItem(new CartItem(2, "Java精通", 34, new BigDecimal(324), new BigDecimal(5435)));
        cart.clear();
        System.out.println(cart);
    }

    @Test
    public void updateCount() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "jerry", 34, new BigDecimal(324), new BigDecimal(5435)));
        cart.addItem(new CartItem(1, "jerry", 34, new BigDecimal(324), new BigDecimal(5435)));
        cart.addItem(new CartItem(2, "Java精通", 34, new BigDecimal(324), new BigDecimal(5435)));
        cart.updateCount(2, 440);
        System.out.println(cart);
    }
}
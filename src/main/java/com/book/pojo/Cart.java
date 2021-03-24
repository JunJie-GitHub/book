package com.book.pojo;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 购物车对象
 */
public class Cart {
//    private Integer totalCount;
//
//    private BigDecimal totalPrice;

    /**
     * key是商品编号, value是商品信息
     * 用HashMap key不会重复
     */
    private Map<Integer, CartItem> items = new LinkedHashMap<Integer, CartItem>();

//    添加商品项
    public void addItem(CartItem cartItem){
        //判断是否存在该商品id, 以存在, 则累加数量, 跟新总金额, 否则直接放集合中
        if (items.containsKey(cartItem.getId())){
            cartItem.setCount(cartItem.getCount() + 1); //数量累加
            cartItem.setTotalPrice( cartItem.getPrice().multiply(new BigDecimal(cartItem.getCount())) ); //更新总金额
        }else{
            items.put(cartItem.getId(), cartItem);
        }
    }

//    删除商品项
    public void deleteItem(Integer id){
        items.remove(id);
    }

//    清空商品项
    public void clear(){
        items.clear();
    }

//    修改商品数量
    public void updateCount(Integer id, Integer count){
        //判断是否存在该商品id, 以存在, 则累加数量, 跟新总金额, 否则直接放集合中
        CartItem cartItem = items.get(id);
        if (items.containsKey(cartItem.getId())){
            cartItem.setCount(count); //数量累加
            cartItem.setTotalPrice( cartItem.getPrice().multiply(new BigDecimal(cartItem.getCount())) ); //更新总金额
        }
    }

    public Integer getTotalCount() {
        Integer totalCount = 0;
        for (Map.Entry<Integer, CartItem>entry : items.entrySet()){
            totalCount += entry.getValue().getCount();
        }
        return totalCount;
    }

    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = new BigDecimal(0);
        for (Map.Entry<Integer, CartItem>entry : items.entrySet()){
            totalPrice = totalPrice.add(entry.getValue().getTotalPrice());
        }
        return totalPrice;
    }


    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + getTotalCount() +
                ", totalPrice=" + getTotalPrice() +
                ", items=" + items +
                '}';
    }
}

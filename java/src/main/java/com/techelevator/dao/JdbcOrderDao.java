package com.techelevator.dao;


import com.techelevator.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcOrderDao implements OrderDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public List<Order> getOrders() {
        List<Order> orders = new ArrayList<>();
        String sql = "SELECT *\n" +
                "FROM orders;";
        try {
            SqlRowSet rs = jdbcTemplate.queryForRowSet(sql);
            while (rs.next()){
                Order order = mapRowToOrder(rs);
                orders.add(order);
            }

        } catch (Exception ex){
            System.out.println("Something went wrong" + ex.getMessage());
        }
        return orders;
    }

    @Override
    public Order getOrderById(int orderId) {
       //Step 1
        Order order = null;

        //Step 2
        String sql = "SELECT order_id, order_name, phone_number, order_date_time, is_delivery, address, delivery_date_time, payment_info, total_cost, order_status, email_address\n" +
                "FROM order\n" +
                "WHERE order_id = ?;";



        //Step 3
        try{
            SqlRowSet rs = jdbcTemplate.queryForRowSet(sql, orderId);

            //Step 4
            while (rs.next()){
                order = mapRowToOrder(rs);
            }

        }catch (Exception ex){
            System.out.println("Something went wrong" + ex.getMessage());
        }

        //step 5
        return order;
    }

    @Override
    public Order createOrder(Order order) {
        //Step 1
        Order newOrder = null;

        //Step 2
        String sql = "INSERT INTO orders(order_name, phone_number, order_date_time, is_delivery, address, delivery_date_time, payment_info, total_cost, order_status, email_address)\n" +
                "VALUES(?,?,?,?,?,?,?,?,?,?) RETURNING order_id;";

        //Step 3
        try{
            int orderId = jdbcTemplate.queryForObject(sql, int.class, order.getOrderName(), order.getPhoneNumber(), order.getOrderDateTime(),order.isDelivery(), order.getAddress(), order.getDeliveryDateTime(),
                    order.getPaymentInfo(), order.getTotalCost(), order.getEmailAddress());

            //Step 4
            newOrder = getOrderById(orderId);

        }catch (Exception ex){
            System.out.println("Something went wrong" + ex.getMessage());
        }

        //step 5
        return  newOrder;
    }

    //private static final OrderRowMapper implements RowMapper<>{
     //   @Override
   // import org.springframework.jdbc.core.RowMapper;
    // }


    private Order mapRowToOrder(SqlRowSet rs){
    Order order = new Order();
    order.setOrderId(rs.getInt("order_id"));
    order.setOrderName(rs.getString("order_name"));
    order.setPhoneNumber(rs.getString("phone_number"));
    order.setOrderDateTime(rs.getTimestamp("order_date_time"));
    order.setDelivery(rs.getBoolean("is_delivery"));
    order.setAddress(rs.getString("address"));
    order.setDeliveryDateTime(rs.getTimestamp("delivery_date_time"));
    order.setPaymentInfo(rs.getString("payment_info"));
    return order;
    }
}

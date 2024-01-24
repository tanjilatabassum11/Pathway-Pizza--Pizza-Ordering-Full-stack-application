package com.techelevator.dao;

import com.techelevator.model.Order;
import com.techelevator.model.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class JdbcOrderDao implements OrderDao {

    private final JdbcTemplate jdbcTemplate;
    private final Logger logger = LoggerFactory.getLogger(JdbcOrderDao.class);

    @Autowired
    public JdbcOrderDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Order> getOrders() {
        String sql = "SELECT * FROM orders;";
        return jdbcTemplate.query(sql, new OrderRowMapper());
    }

    @Override
    public Optional<Order> getOrderById(int orderId) {
        String sql = "SELECT * FROM orders WHERE order_id = ?";
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject(sql, new OrderRowMapper(), orderId));
        } catch (Exception e) {
            logger.error("Error retrieving order with ID " + orderId, e);
            return Optional.empty();
        }
    }

    @Override
    @Transactional
    public Order createOrder(Order order) {
        //Step 1
//        String sql = "INSERT INTO orders(order_name, phone_number, order_date_time, is_delivery, address, delivery_date_time, payment_info, total_cost, order_status, email_address) " +
//                "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING order_id;";
        String sql = "INSERT INTO orders(order_name, phone_number, is_delivery, address, delivery_date_time, payment_info, total_cost, order_status, email_address) " +
                "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING order_id;";
        //Step 2
        try {
            int orderId = jdbcTemplate.queryForObject(sql, Integer.class, order.getOrderName(), order.getPhoneNumber(), order.isDelivery(), order.getAddress(), order.getDeliveryDateTime(), order.getPaymentInfo(), order.getTotalCost(), order.getOrderStatus(), order.getEmailAddress());
            return getOrderById(orderId).orElse(null);
        } catch (Exception e) {
            logger.error("Error creating order", e);
            return null;
        }
    }

    @Override
    @Transactional
    public Order updateOrder(Order order) {
        String sql = "UPDATE orders SET order_name = ?, phone_number = ?, order_date_time = ?, is_delivery = ?, address = ?, delivery_date_time = ?, payment_info = ?, total_cost = ?, order_status = ?, email_address = ? " +
                "WHERE order_id = ?";
        try {
            jdbcTemplate.update(sql, order.getOrderName(), order.getPhoneNumber(), order.getOrderDateTime(), order.isDelivery(), order.getAddress(), order.getDeliveryDateTime(), order.getPaymentInfo(), order.getTotalCost(), order.getOrderStatus(), order.getEmailAddress(), order.getOrderId());
            return getOrderById(order.getOrderId()).orElse(null);
        } catch (Exception e) {
            logger.error("Error updating order with ID " + order.getOrderId(), e);
            return null;
        }
    }

    @Override
    @Transactional
    public boolean deleteOrder(int orderId) {
        String sql = "DELETE FROM orders WHERE order_id = ?";
        try {
            int rowsAffected = jdbcTemplate.update(sql, orderId);
            return rowsAffected > 0;
        } catch (Exception e) {
            logger.error("Error deleting order with ID " + orderId, e);
            return false;
        }
    }

    @Override
   public void addPizzasToOrder(int orderId, int pizzaId, int quantity){
    String sql = "INSERT INTO orders_pizzas(order_id, pizza_id, quantity)\n" +
            "VALUES(?,?,?);";
    try {
        jdbcTemplate.update(sql, orderId, pizzaId, quantity);
    } catch(Exception e){
        System.out.println("Something went wrong adding pizza to order, please try again");
    }

   }

    private static final class OrderRowMapper implements RowMapper<Order> {
        @Override
        public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
            Order order = new Order();
            order.setOrderId(rs.getInt("order_id"));
            order.setOrderName(rs.getString("order_name"));
            order.setPhoneNumber(rs.getString("phone_number"));
            order.setOrderDateTime(rs.getTimestamp("order_date_time"));
            order.setDelivery(rs.getBoolean("is_delivery"));
            order.setAddress(rs.getString("address"));
            order.setDeliveryDateTime(rs.getTimestamp("delivery_date_time"));
            order.setPaymentInfo(rs.getString("payment_info"));
            order.setTotalCost(rs.getBigDecimal("total_cost"));
            order.setOrderStatus(rs.getString("order_status"));
            order.setEmailAddress(rs.getString("email_address"));
            return order;
        }
    }
}

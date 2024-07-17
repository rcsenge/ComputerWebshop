package org.example.service;

import org.example.dao.CustomerDAO;
import org.example.dao.ProductDAO;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

public class OrderService {
    private final ProductDAO productDAO;
    private final CustomerDAO customerDAO;

    public OrderService(ProductDAO productDAO, CustomerDAO customerDAO) {
        this.productDAO = productDAO;
        this.customerDAO = customerDAO;
    }

    public void createOrders(Connection con) throws SQLException {
        List<Integer> productIds = productDAO.getProductIds(con);
        List<Integer> customerIds = customerDAO.getCustomerIds(con);

        if (productIds.isEmpty() || customerIds.isEmpty()) {
            throw new SQLException("No products or customers available to create orders");
        }

        String insertOrderQuery = """
                INSERT INTO `order`(customer_id, product_id, quantity, order_date, order_completed_at, 
                is_personal_pickup, total_final_price, invoice_number)
                VALUES(?, ?, ?, ?, ?, ?, ?, ?);
                """;

        PreparedStatement pstmt = con.prepareStatement(insertOrderQuery);
        Random random = new Random();

        for (int i = 0; i < 20; i++) {
            int customerId = customerIds.get(random.nextInt(customerIds.size()));
            int productId = productIds.get(random.nextInt(productIds.size()));
            int quantity = random.nextInt(4) + 1;
            Date orderDate = Date.valueOf(LocalDate.now().minusDays(random.nextInt(14 - 1) + 1));
            Date orderCompletedAt = Date.valueOf(LocalDate.now());
            String isPersonalPickup = "N";
            float productPrice = productDAO.getProductPrice(con, productId);
            float totalFinalPrice = productPrice * quantity;
            String invoiceNumber = generateInvoiceNumber();

            pstmt.setInt(1, customerId);
            pstmt.setInt(2, productId);
            pstmt.setInt(3, quantity);
            pstmt.setDate(4, orderDate);
            pstmt.setDate(5, orderCompletedAt);
            pstmt.setString(6, isPersonalPickup);
            pstmt.setFloat(7, totalFinalPrice);
            pstmt.setString(8, invoiceNumber);

            pstmt.addBatch();
        }

        pstmt.executeBatch();
        pstmt.close();
    }

    private String generateInvoiceNumber() {
        Random r = new Random();
        return "INV" + (r.nextInt(900000) + 100000);
    }
}

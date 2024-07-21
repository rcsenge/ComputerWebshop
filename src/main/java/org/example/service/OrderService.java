package org.example.service;

import org.example.MyRuntimeException;
import org.example.dao.CustomerDAO;
import org.example.dao.ProductDAO;
import org.example.model.Order;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

public class OrderService {
    private final Random random;

    public OrderService(Random random) {
        this.random = random;
    }

    public Order createOrder(ProductDAO productDAO, CustomerDAO customerDAO) {
        List<Integer> productIds = productDAO.getProductIds();
        List<Integer> customerIds = customerDAO.getCustomerIds();

        if (productIds.isEmpty() || customerIds.isEmpty()) {
            throw new MyRuntimeException("No products or customers available to create orders");
        }

        int customerId = customerIds.get(random.nextInt(customerIds.size()));
        int productId = productIds.get(random.nextInt(productIds.size()));
        int quantity = random.nextInt(4) + 1;
        LocalDate orderDate = LocalDate.now().minusDays(random.nextInt(14 - 1) + 1);
        LocalDate orderCompletedAt = LocalDate.now();
        String isPersonalPickup = "N";
        double productPrice = productDAO.getProductPrice(productId);
        double totalFinalPrice = productPrice * quantity;
        String invoiceNumber = generateInvoiceNumber();
        return new Order(customerId, productId, quantity, orderDate, orderCompletedAt, isPersonalPickup, totalFinalPrice, invoiceNumber);
    }


    public String generateInvoiceNumber() {
        Random r = new Random();
        return "INV" + (r.nextInt(900000) + 100000);
    }
}
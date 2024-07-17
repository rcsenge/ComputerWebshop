package org.example.model;

import java.time.LocalDate;

public class Order {
    private final int id;
    private final int customerId;
    private final int productId;
    private final int quantity;
    private final LocalDate orderDate;
    private final LocalDate orderCompletedAt;
    private final String isPersonalPickup;
    private final double totalFinalPrice;
    private final String invoiceNumber;

    public Order(int id, int customerId, int productId, int quantity, LocalDate orderDate, LocalDate orderCompletedAt, String isPersonalPickup, double totalFinalPrice, String invoiceNumber) {
        this.id = id;
        this.customerId = customerId;
        this.productId = productId;
        this.quantity = quantity;
        this.orderDate = orderDate;
        this.orderCompletedAt = orderCompletedAt;
        this.isPersonalPickup = isPersonalPickup;
        this.totalFinalPrice = totalFinalPrice;
        this.invoiceNumber = invoiceNumber;
    }
}

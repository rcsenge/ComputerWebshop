package org.example.model;

import java.time.LocalDate;

public record Order(int customerId, int productId, int quantity, LocalDate orderDate,
                    LocalDate orderCompletedAt, String isPersonalPickup, double totalFinalPrice, String invoiceNumber) {

}

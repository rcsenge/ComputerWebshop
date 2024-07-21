package org.example.model;

public record Product(int id, String name, String description, double price, int inStock, String brand,
                      String productType, String category) {
}

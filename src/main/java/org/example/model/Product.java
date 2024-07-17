package org.example.model;

public class Product {
    private final int id;
    private final String name;
    private final String description;
    private final double price;
    private final int inStock;
    private final String brand;
    private final String productType;
    private final String category;

    public Product(int id, String name, String description, double price, int inStock, String brand, String productType, String category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.inStock = inStock;
        this.brand = brand;
        this.productType = productType;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getInStock() {
        return inStock;
    }

    public String getBrand() {
        return brand;
    }

    public String getProductType() {
        return productType;
    }

    public String getCategory() {
        return category;
    }
}

# Order Management System

This application is a simple order management yystem that interacts with a database to manage customers, products, and orders. It provides functionality to retrieve customer and product information, calculate order details, and insert new orders into the database.

## Features

- **Customer Management**: Retrieve customer IDs from the database.
- **Product Management**: Retrieve product IDs and prices from the database.
- **Order Management**: Generate and insert multiple orders into the database based on customer and product data.
- **Configuration Management**: Load database connection properties from a configuration file.
  
## Project Structure

- **DAO Layer**: Interfaces and implementations for data access objects (DAOs) that interact with the database.
  - `CustomerDAO` and `CustomerDAOImpl`: Handle customer-related operations.
  - `ProductDAO` and `ProductDAOImpl`: Handle product-related operations.
  - `OrderDAO` and `OrderDAOImpl`: Handle order-related operations, including batch inserts.
- **Model Layer**: Defines data models (Customer, Product, Order) as Java Records to represent entities in the database.
- **Service Layer**: Business logic for order creation, including generating random order details.
  - `OrderService`: Creates orders and generates unique invoice numbers.
- **Utility Classes**:
  - `DatabaseConnection`: Establishes and provides a connection to the database.
  - `ConfigManager`: Loads database connection properties from `config.properties`.
  - `MyRuntimeException`: Custom exception for handling application-specific errors.

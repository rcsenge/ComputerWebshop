package org.example.dao;

import java.util.List;

public interface ProductDAO {
    double getProductPrice(int productId);

    List<Integer> getProductIds();
}

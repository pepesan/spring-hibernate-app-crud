package com.companyname.springapp.repository;

/**
 * Created by pepesan on 6/10/16.
 */
import java.util.List;

import com.companyname.springapp.domain.Product;

public interface ProductDao {

    public List<Product> getProductList();

    public void saveProduct(Product prod);

    void addProduct(Product product);

    void removeProductByiD(Integer id);

    Product getProductByID(Integer id);
}

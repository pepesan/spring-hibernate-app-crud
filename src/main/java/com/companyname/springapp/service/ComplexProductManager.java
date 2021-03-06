package com.companyname.springapp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.companyname.springapp.domain.Product;
import com.companyname.springapp.repository.ProductDao;

@Component
public class ComplexProductManager implements ProductManager {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1614081138325579223L;

    @Autowired
    private ProductDao productDao;

    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

	public List<Product> getProducts() {
        return productDao.getProductList();
    }

    public void addProduct(Product product) {
        productDao.addProduct(product);
    }

    public void removeProductById(Integer id) {
        productDao.removeProductByiD(id);
    }

    public Product getProductByID(Integer id) {
        return productDao.getProductByID(id);
    }

    public void editProduct(Product product) {
        productDao.saveProduct(product);
    }

    public void increasePrice(int percentage) {
        List<Product> products = productDao.getProductList();
    	if (products != null) {
            for (Product product : products) {
                double newPrice = product.getPrice().doubleValue() * 
                                    (100 + percentage)/100;
                product.setPrice(newPrice);
                productDao.saveProduct(product);
            }
        }          
	}

}

package com.companyname.springapp.service;

import java.util.List;

import com.companyname.springapp.domain.Product;

public class SimpleProductManager implements ProductManager {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1614081138325579223L;
	
	private List<Product> products;

	public List<Product> getProducts() {
		return products;        
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProductById(Integer id) {
        for (Product p: products){
            if(p.getId().equals(id)){
                products.remove(p);
            }
        }
    }

    public void increasePrice(int percentage) {
    	if (products != null) {
            for (Product product : products) {
                double newPrice = product.getPrice().doubleValue() * 
                                    (100 + percentage)/100;
                product.setPrice(newPrice);
            }
        }          
	}
	
    public void setProducts(List<Product> products) {
        this.products=products;        
    }

}

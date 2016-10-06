package com.companyname.springapp.web;

/**
 * Created by pepesan on 5/10/16.
 */

import com.companyname.springapp.domain.Product;
import com.companyname.springapp.service.FormPriceIncrease;
import com.companyname.springapp.service.ProductManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping(value="/addproduct.htm")
public class ProductFormController {

    /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    private ProductManager productManager;

    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(
            @Valid Product product,
            BindingResult result)
    {
        if (result.hasErrors()) {
            return "addproduct";
        }

        logger.info("Añadiendo un producto");

        productManager.addProduct(product);

        return "redirect:/listado.htm";
    }

    @RequestMapping(method = RequestMethod.GET)
    protected Product formBackingObject(
            HttpServletRequest request
    )
            throws ServletException {
        Product product=new Product();
        return product;
    }

    public void setProductManager(ProductManager productManager) {
        this.productManager = productManager;
    }

    public ProductManager getProductManager() {
        return productManager;
    }

}

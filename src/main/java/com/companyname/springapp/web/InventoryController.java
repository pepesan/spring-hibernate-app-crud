package com.companyname.springapp.web;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.companyname.springapp.domain.Product;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.companyname.springapp.service.ProductManager;

@Controller
public class InventoryController {

    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    private ProductManager productManager;

    @RequestMapping(value="/listado.htm")
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	String now = (new Date()).toString();
        logger.info("Returning hello view with " + now);

        Map<String, Object> myModel = new HashMap<String, Object>();
        myModel.put("now", now);
        myModel.put("products", this.productManager.getProducts());

        return new ModelAndView("listado", "model", myModel);
    }
    @RequestMapping(value="delete-{id}.htm")
    public ModelAndView borraProducto(
            @PathVariable("id") Integer id){
        productManager.removeProductById(id);
        return new ModelAndView("redirect:/listado.htm");
    }
    @RequestMapping(value="show-{id}.htm")
    public ModelAndView muestraProducto(
            @PathVariable("id") Integer id){
        //productManager.removeProductById(id);

        //coger el objeto con ese ID
        Product product=productManager.getProductByID(id);
        //pasar el objeto del producto a la vista
        return new ModelAndView("mostrar","product",product);
    }

    public void setProductManager(ProductManager productManager) {
        this.productManager = productManager;
    }
}
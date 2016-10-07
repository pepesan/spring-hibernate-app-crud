package com.companyname.springapp.web;

/**
 * Created by pepesan on 5/10/16.
 */

import com.companyname.springapp.domain.Product;
import com.companyname.springapp.service.ProductManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping(value="/edit-{id}.htm")
public class EditProductFormController {

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
            return "editproduct";
        }

        logger.info("Editando un producto");

        productManager.editProduct(product);

        return "redirect:/listado.htm";
    }

    @RequestMapping(method = RequestMethod.GET)
    protected ModelAndView formBackingObject(@PathVariable("id") Integer id,
                                             HttpServletRequest request
    )
            throws ServletException {
        return new ModelAndView("editproduct","product",productManager.getProductByID(id));

    }

    public void setProductManager(ProductManager productManager) {
        this.productManager = productManager;
    }

    public ProductManager getProductManager() {
        return productManager;
    }

}

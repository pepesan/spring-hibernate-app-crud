package com.companyname.springapp.web;

/**
 * Created by pepesan on 5/10/16.
 */
import com.companyname.springapp.service.FormPriceIncrease;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.companyname.springapp.service.ProductManager;

@Controller
@RequestMapping(value="/priceincrease.htm")
public class PriceIncreaseFormController {

    /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    private ProductManager productManager;

    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(
            @Valid FormPriceIncrease formPriceIncrease,
            BindingResult result)
    {
        if (result.hasErrors()) {
            return "priceincrease";
        }

        int increase = formPriceIncrease.getPercentage();
        logger.info("Increasing prices by " + increase + "%.");

        productManager.increasePrice(increase);

        return "redirect:/listado.htm";
    }

    @RequestMapping(method = RequestMethod.GET)
    protected FormPriceIncrease formBackingObject(
            HttpServletRequest request
    )
            throws ServletException {
        FormPriceIncrease formPriceIncrease
                = new FormPriceIncrease();
        formPriceIncrease.setPercentage(15);
        return formPriceIncrease;
    }

    public void setProductManager(ProductManager productManager) {
        this.productManager = productManager;
    }

    public ProductManager getProductManager() {
        return productManager;
    }

}

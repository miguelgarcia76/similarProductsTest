package com.mgp_test.similarProducts.controllers;

import java.util.ArrayList;
import java.util.List;

import com.mgp_test.similarProducts.commons.exceptions.NotFoundException;
import com.mgp_test.similarProducts.services.product.ProductDetail;
import com.mgp_test.similarProducts.services.product.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * This service returns the list of similar products to a given one ordered by
     * similarity
     */
    @GetMapping(value = "/product/{productId}/similar")
    public ResponseEntity<List<ProductDetail>> getProductSimilar(@PathVariable Integer productId) {

        List<ProductDetail> similarProducts = new ArrayList<ProductDetail>();

        HttpStatus httpStatus = HttpStatus.OK;

        try {

            similarProducts = productService.getProductSimilar(productId);

        }catch(NotFoundException nfe){
            httpStatus = HttpStatus.NOT_FOUND;
        } catch (RuntimeException ex) {
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        } catch (Exception ex) {
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return new ResponseEntity<List<ProductDetail>>(similarProducts, httpStatus);

    }
}

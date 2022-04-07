package com.mgp_test.similarProducts.services.product.response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.mgp_test.similarProducts.services.product.ProductDetail;

/**
 * List of similar products to a given one ordered by similarity.
 */
public class SimilarProducts implements Serializable {

    List<ProductDetail> items = new ArrayList<ProductDetail>();

    public List<ProductDetail> getItems() {
        return items;
    }

    public void setItems(List<ProductDetail> items) {
        this.items = items;
    }

}

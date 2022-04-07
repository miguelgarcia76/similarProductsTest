package com.mgp_test.similarProducts.services.product;

import java.util.List;

import com.mgp_test.similarProducts.commons.exceptions.NotFoundException;

public interface ProductService {
    
    /**
	 * This service returns the list of similar products to a given one ordered by similarity
     * 
	 * @param productId
	 * 
	 * @return List<ProductDetail>
	 * 
	 * @throws Exception
	 */
	List<ProductDetail> getProductSimilar(Integer productId) throws Exception, RuntimeException, NotFoundException;
}

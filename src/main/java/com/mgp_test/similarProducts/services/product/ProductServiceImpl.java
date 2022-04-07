package com.mgp_test.similarProducts.services.product;

import java.util.ArrayList;
import java.util.List;

import com.mgp_test.similarProducts.commons.exceptions.NotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductServiceImpl implements ProductService {

    /**
     * _HTTP_PRODUCT_URL
     */
    private static final String _HTTP_PRODUCT_URL = "http://localhost:3001/product/";

    @Override
    public List<ProductDetail> getProductSimilar(Integer productId)
            throws Exception, RuntimeException, NotFoundException {

        try {

            List<ProductDetail> productList = new ArrayList<ProductDetail>();
            
            List<Integer> similarIds = getSimilarIds(productId);

            for (Integer similarId : similarIds) {
                productList.add(getProductDetail(similarId));
            }

            return productList;

        } catch (NotFoundException nfe) {
            throw nfe;
        } catch (RuntimeException re) {
            throw re;
        } catch (Exception e) {
            throw e;
        }

    }

    /**
     * Method to obtain similar product Ids for a given product Id
     * 
     * @param productId
     * @return List<Integer> list of a similar product Ids
     * 
     * @throws RestClientException
     */
    @SuppressWarnings("unchecked")
    private List<Integer> getSimilarIds(Integer productId) throws NotFoundException {

        try {

            RestTemplate restTemplate = new RestTemplate();

            String url = _HTTP_PRODUCT_URL + productId + "/similarids";

            List<Integer> similarIds = restTemplate.getForObject(url, List.class);

            return similarIds;

        } catch (RestClientException rce) {
            throw new NotFoundException();
        } catch (RuntimeException rte) {
            throw rte;
        }
    }

    /**
     * Method to obtain the detail of a product for a given product Id
     * 
     * @param productId
     * @return ProductDetail with the detail
     * 
     * @throws NotFoundException
     */
    private ProductDetail getProductDetail(Integer productId) throws NotFoundException {

        try {
            RestTemplate restTemplate = new RestTemplate();

            String url = _HTTP_PRODUCT_URL + productId;

            return restTemplate.getForObject(url, ProductDetail.class);

        } catch (RestClientException rce) {
            throw new NotFoundException();
        } catch (RuntimeException rte) {
            throw rte;
        }
    }
}

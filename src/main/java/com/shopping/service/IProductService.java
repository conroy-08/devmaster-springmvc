package com.shopping.service;

import java.util.List;

import com.shopping.dto.ProductDTO;

public interface IProductService {
   List<ProductDTO> getAll();
   ProductDTO createOrUpdate(ProductDTO product);
   ProductDTO findOneById(Long id);
   void deleteProduct(Long id);
   
}

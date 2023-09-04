package br.com.mrocha.productms.service;

import br.com.mrocha.productms.dto.ProductDTO;

import java.util.Optional;

public interface ProductService {

    Optional<ProductDTO> create(ProductDTO request);
}

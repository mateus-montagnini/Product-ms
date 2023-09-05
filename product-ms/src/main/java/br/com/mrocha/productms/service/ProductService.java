package br.com.mrocha.productms.service;

import br.com.mrocha.productms.dto.ProductDTO;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Optional<ProductDTO> create(ProductDTO request);

    List<ProductDTO> getAll();

    Optional<ProductDTO> getById(Long id);

    boolean inactive(Long id);

    boolean delete(Long id);
}

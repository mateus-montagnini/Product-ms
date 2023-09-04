package br.com.mrocha.productms.service;

import br.com.mrocha.productms.dto.ProductDTO;
import br.com.mrocha.productms.model.Product;
import br.com.mrocha.productms.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.mrocha.productms.service.ProductServiceImpl;

import java.util.Optional;

public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;
    @Override
    public Optional<ProductDTO> create(ProductDTO request) {
        ModelMapper mapper = new ModelMapper();
        Product product = mapper.map(request, Product.class);

        repository.save(product);

        ProductDTO response = mapper.map(product, ProductDTO.class);

        return Optional.of(response);
    }
}

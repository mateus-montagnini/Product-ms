package br.com.mrocha.productms.service;

import br.com.mrocha.productms.dto.ProductDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class ProductServiceTest {

    @Autowired
    private ProductService service;

    @Test
    public void shouldCreateProduct() {
        ProductDTO request = new ProductDTO();
        request.setName("Produto Novo");
        request.setDescription("Descricao do produto com mais de cinquenta caracteres Descricao do produto com mais de cinquenta caracteres Descricao do produto com mais de cinquenta caracteres");
        request.setPrice(6999.90);

        Optional<ProductDTO> response = service.create(request);
        Assertions.assertNotNull(response.get());
        Assertions.assertEquals(request.getName(), response.get().getName());
        Assertions.assertEquals(request.getDescription(), response.get().getDescription());
        Assertions.assertEquals(request.getPrice(), response.get().getPrice());
        Assertions.assertTrue(response.get().isAvailable());
    }
}

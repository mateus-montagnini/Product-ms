package br.com.mrocha.productms.service;

import br.com.mrocha.productms.dto.ProductDTO;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.BEFORE_TEST_METHOD;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@Sql(executionPhase = BEFORE_TEST_METHOD, scripts = {"classpath:clear-database.sql"})
public class ProductServiceTest {

    @Autowired
    private ProductService service;

    @BeforeAll
    public static void setUp() {
        FixtureFactoryLoader.loadTemplates("br.com.mrocha.productms.fixture");
    }

    @Test
    public void shouldCreateProduct() {
        ProductDTO request = Fixture.from(ProductDTO.class).gimme("valid");
        Optional<ProductDTO> response = service.create(request);
        Assertions.assertNotNull(response.get());
        Assertions.assertEquals(request.getName(), response.get().getName());
        Assertions.assertEquals(request.getDescription(), response.get().getDescription());
        Assertions.assertEquals(request.getPrice(), response.get().getPrice());
        Assertions.assertTrue(response.get().isAvailable());
    }

    @Test
    public void shouldGetAllProducts() {
        ProductDTO request = Fixture.from(ProductDTO.class).gimme("valid");
        Optional<ProductDTO> response = service.create(request);
        List<ProductDTO> responses = service.getAll();
        System.out.println(">>>>>>>>>> " + responses.size());

        assertNotNull(responses);
        assertEquals(responses.get(0).getName(), response.get().getName());
        assertEquals(responses.get(0).getDescription(), response.get().getDescription());
        Assertions.assertEquals(responses.get(0).getPrice(), response.get().getPrice());
    }
}

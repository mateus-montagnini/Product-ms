package br.com.mrocha.productms.fixture;

import br.com.mrocha.productms.dto.ProductDTO;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class ProductTemplateLoader implements TemplateLoader {
    @Override
    public void load() {
        Fixture.of(ProductDTO.class).addTemplate("valid", new Rule(){{
            add("name", random("Cadeira", "Mesa", "Abajur", "Cama"));
            add("description", "Descricao do produto com mais de cinquenta caracteres Descricao do produto com mais de cinquenta caracteres Descricao do produto com mais de cinquenta caracteres");
            add("price", random(Double.class, range(0.01, 9999.99)));
        }});
    }
}

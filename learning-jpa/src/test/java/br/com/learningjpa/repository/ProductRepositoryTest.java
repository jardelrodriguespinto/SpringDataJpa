package br.com.learningjpa.repository;

import br.com.learningjpa.enums.ProductStatusEnum;
import br.com.learningjpa.model.Product;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProductRepositoryTest
{
    @Autowired
    ProductRepository productRepository;

    @Test
    void saveProduct()
    {
        Product product = new Product();

        product.setName("Pen");
        product.setDescription("Object use to write on a paper");
        product.setStatus(ProductStatusEnum.IN_STOCK);

        productRepository.save(product);

        assertThat(product).isNotNull();
    }

    @Test
    void testGetByCategory(){
        Product product = productRepository.findByDescription("PRODUCT1");

        assertThat(product).isNotNull();
    }

}

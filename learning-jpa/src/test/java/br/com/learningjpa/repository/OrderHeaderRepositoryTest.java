package br.com.learningjpa.repository;

import br.com.learningjpa.enums.OrderStatusEnum;
import br.com.learningjpa.enums.ProductStatusEnum;
import br.com.learningjpa.model.Customer;
import br.com.learningjpa.model.OrderHeader;
import static org.assertj.core.api.Assertions.assertThat;

import br.com.learningjpa.model.OrderLine;
import br.com.learningjpa.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Set;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class OrderHeaderRepositoryTest
{
    @Autowired
    private OrderHeaderRepository orderHeaderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CustomerRepository customerRepository;

    Product product;
    Customer customer;
    @BeforeEach
    void setUp(){
        Product newProduct = new Product();
        newProduct.setStatus(ProductStatusEnum.NEW);
        newProduct.setDescription("New Product");
        product = productRepository.saveAndFlush(newProduct);

        Customer newCustomer = new Customer();
        newCustomer.setName("Fulano da Silva");
        newCustomer.setEmail("testinho@teste.com");
        newCustomer.setPhone("(49) 9 5654-8984");
        customer = customerRepository.saveAndFlush(customer);
    }

    @Test
    void saveOrderLine(){
        OrderHeader orderHeader = new OrderHeader();
        orderHeader.setCustomer(customer);
        orderHeader.setStatus(OrderStatusEnum.NEW);

        OrderLine orderLine = new OrderLine();
        orderLine.setQuantityOrdered(15);
        orderLine.setProduct(product);

        orderHeader.addOrderLine(orderLine);

        orderHeaderRepository.flush();

        assertThat(orderHeader).isNotNull();
        assertThat(orderHeader.getOrderLines()).isNotNull();
        assertThat(orderHeader.getOrderLines()).isNotEmpty();
    }
    @Test
    void saveOrder()
    {
        OrderHeader orderHeader = new OrderHeader();
        orderHeader.setCustomer(customer);
        orderHeader.setStatus(OrderStatusEnum.NEW);

        orderHeaderRepository.save(orderHeader);

        assertThat(orderHeader).isNotNull();
        assertThat(orderHeader.getId()).isNotNull();
    }
}

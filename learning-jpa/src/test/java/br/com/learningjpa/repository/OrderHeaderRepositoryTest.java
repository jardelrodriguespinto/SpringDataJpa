package br.com.learningjpa.repository;

import br.com.learningjpa.enums.ProductStatusEnum;
import br.com.learningjpa.enums.OrderStatusEnum;
import br.com.learningjpa.model.*;

import static org.assertj.core.api.Assertions.assertThat;

import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

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

    @Autowired
    private OrderApprovalRepository orderApprovalRepository;

    Product product;
    Customer customer;
    OrderApproval orderApproval;
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

        orderApproval = new OrderApproval();
        orderApproval.setApprovedBy("Fulano Da Silva");
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
        orderHeader.setOrderApproval(orderApproval);

        orderHeaderRepository.flush();

        assertThat(orderHeader).isNotNull();
        assertThat(orderHeader.getOrderLines()).isNotNull();
        assertThat(orderHeader.getOrderLines()).isNotEmpty();
        assertThat(orderHeader.getOrderApproval()).isNotNull();

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

    @Test
    void deleteOnCascade()
    {
        OrderHeader orderHeaderTest = new OrderHeader();
        Customer customerTest = new Customer();
        customerTest.setName("new customer");
        orderHeaderTest.setCustomer(customerRepository.save(customerTest));

        OrderLine orderLine = new OrderLine();
        orderLine.setQuantityOrdered(15);
        orderLine.setProduct(product);

        OrderApproval orderApproval1 = new OrderApproval("me");

        orderHeaderTest.setOrderApproval(orderApproval1);

        orderHeaderTest.addOrderLine(orderLine);
        OrderHeader savedOrder = orderHeaderRepository.saveAndFlush(orderHeaderTest);

        orderHeaderRepository.deleteById(savedOrder.getId());
        orderHeaderRepository.flush();

        Assertions.assertThrows(EntityNotFoundException.class, () -> {
            OrderHeader fetched = orderHeaderRepository.getById(savedOrder.getId());

            assertThat(fetched).isNull();
        });

    }


}

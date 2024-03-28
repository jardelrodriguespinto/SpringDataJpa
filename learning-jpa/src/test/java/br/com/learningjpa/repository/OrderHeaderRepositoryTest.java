package br.com.learningjpa.repository;

import br.com.learningjpa.enums.OrderStatusEnum;
import br.com.learningjpa.model.OrderHeader;
import static org.assertj.core.api.Assertions.assertThat;
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

    @Test
    void saveOrder()
    {
        OrderHeader orderHeader = new OrderHeader();
        orderHeader.setCustomerName("Joaquim");
        orderHeader.setStatus(OrderStatusEnum.NEW);

        orderHeaderRepository.save(orderHeader);

        assertThat(orderHeader).isNotNull();
        assertThat(orderHeader.getId()).isNotNull();
    }
}

package br.com.learningjpa.model;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;


class BaseEntityTest {

    @Test
    void testEquals()
    {
        OrderHeader orderHeader1 = new OrderHeader();
        orderHeader1.setId(1L);

        OrderHeader orderHeader2 = new OrderHeader();
        orderHeader2.setId(1L);

        assert orderHeader1.equals(orderHeader2);
    }

    @Test
    void testNotEquals()
    {
        OrderHeader orderHeader1 = new OrderHeader();
        orderHeader1.setId(1L);

        OrderHeader orderHeader2 = new OrderHeader();
        orderHeader2.setId(2L);

        assertThat(orderHeader1.equals(orderHeader2)).isFalse();
    }
}
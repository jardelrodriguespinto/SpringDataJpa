package br.com.learningjpa.bootstrap;

import br.com.learningjpa.model.OrderHeader;
import br.com.learningjpa.repository.OrderHeaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BootstrapOrderService {

    @Autowired
    OrderHeaderRepository orderHeaderRepository;

    @Transactional
    public void readOrderData(){
        OrderHeader orderHeader = orderHeaderRepository.findById(1L).get();

        orderHeader.getOrderLines().forEach(orderLine -> {
            System.out.println(orderLine.getProduct().getDescription());

            orderLine.getProduct().getCategories().forEach(category -> {
                System.out.println(category.getDescription());
            });
        });
    }

}

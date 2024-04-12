package br.com.learningjpa.bootstrap;

import br.com.learningjpa.model.Customer;
import br.com.learningjpa.model.OrderHeader;
import br.com.learningjpa.repository.CustomerRepository;
import br.com.learningjpa.repository.OrderHeaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Component
public class Bootstrap implements CommandLineRunner {

    @Autowired
    BootstrapOrderService bootstrapOrderService;

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public void run(String... args) throws Exception {
        bootstrapOrderService.readOrderData();

        Customer customer = new Customer();
        customer.setName("Nome");
        Customer savedCustomer = customerRepository.save(customer);

        System.out.println("The customer version is: " + savedCustomer.getVersion());

        customerRepository.deleteById(customer.getId());

    }
}


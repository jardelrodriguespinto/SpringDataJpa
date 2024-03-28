package br.com.learningjpa.repository;

import br.com.learningjpa.model.OrderHeader;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderHeaderRepository extends JpaRepository<OrderHeader, Long>
{
}

package br.com.learningjpa.repository;

import br.com.learningjpa.model.OrderApproval;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderApprovalRepository extends JpaRepository<OrderApproval, Long> {
}

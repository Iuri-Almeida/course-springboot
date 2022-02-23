package br.com.ialmeida.course.repositories;

import br.com.ialmeida.course.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}

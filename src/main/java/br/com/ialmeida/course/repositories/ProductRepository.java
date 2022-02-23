package br.com.ialmeida.course.repositories;

import br.com.ialmeida.course.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}

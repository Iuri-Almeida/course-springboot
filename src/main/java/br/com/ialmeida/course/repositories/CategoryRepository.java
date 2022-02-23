package br.com.ialmeida.course.repositories;

import br.com.ialmeida.course.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}

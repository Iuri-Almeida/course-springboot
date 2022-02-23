package br.com.ialmeida.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ialmeida.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}

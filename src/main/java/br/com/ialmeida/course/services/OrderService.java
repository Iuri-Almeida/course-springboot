package br.com.ialmeida.course.services;

import br.com.ialmeida.course.entities.Order;
import br.com.ialmeida.course.entities.User;
import br.com.ialmeida.course.repositories.OrderRepository;
import br.com.ialmeida.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order findById(Long id) {
        Optional<Order> obj = orderRepository.findById(id);
        return obj.orElse(null);
    }

}

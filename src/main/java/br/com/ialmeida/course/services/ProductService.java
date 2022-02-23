package br.com.ialmeida.course.services;

import br.com.ialmeida.course.entities.Product;
import br.com.ialmeida.course.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository userRepository;

    public List<Product> findAll() {
        return userRepository.findAll();
    }

    public Product findById(Long id) {
        Optional<Product> obj = userRepository.findById(id);
        return obj.orElse(null);
    }

}

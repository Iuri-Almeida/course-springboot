package br.com.ialmeida.course.resources;

import br.com.ialmeida.course.entities.Product;
import br.com.ialmeida.course.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {

	@Autowired
	private ProductService userService;

	@GetMapping
	public ResponseEntity<List<Product>> findAll() {
		List<Product> list = userService.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable("id") Long id) {
		Product user = userService.findById(id);
		return ResponseEntity.ok().body(user);
	}

}

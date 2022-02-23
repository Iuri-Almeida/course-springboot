package br.com.ialmeida.course.config;

import java.time.Instant;
import java.util.Arrays;

import br.com.ialmeida.course.entities.Category;
import br.com.ialmeida.course.entities.Order;
import br.com.ialmeida.course.entities.Product;
import br.com.ialmeida.course.entities.enums.OrderStatus;
import br.com.ialmeida.course.repositories.CategoryRepository;
import br.com.ialmeida.course.repositories.OrderRepository;
import br.com.ialmeida.course.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.ialmeida.course.entities.User;
import br.com.ialmeida.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;

	@Override
	public void run(String... args) throws Exception {

		// adding categories
		Category c1 = new Category(null, "Electronics");
		Category c2 = new Category(null, "Books");
		Category c3 = new Category(null, "Computers");
		categoryRepository.saveAll(Arrays.asList(c1, c2, c3));

		// adding products
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

		// adding categories to products
		p1.getCategories().add(c2);
		p2.getCategories().add(c1);
		p2.getCategories().add(c3);
		p3.getCategories().add(c3);
		p4.getCategories().add(c3);
		p5.getCategories().add(c2);
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

		// adding users
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		User u3 = new User(null, "Bob Marley", "bob@gmail.com", "966666666", "123456");
		userRepository.saveAll(Arrays.asList(u1, u2, u3));

		// adding orders
		Order o1 = new Order(null, Instant.parse("2021-02-23T13:30:56Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2021-02-25T17:02:27Z"), OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2021-02-25T22:34:11Z"), OrderStatus.WAITING_PAYMENT, u3);
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		
	}
	
	

}

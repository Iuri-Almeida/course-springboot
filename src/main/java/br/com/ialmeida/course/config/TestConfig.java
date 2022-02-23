package br.com.ialmeida.course.config;

import java.time.Instant;
import java.util.Arrays;

import br.com.ialmeida.course.entities.Order;
import br.com.ialmeida.course.repositories.OrderRepository;
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

	@Override
	public void run(String... args) throws Exception {

		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		User u3 = new User(null, "Bob Marley", "bob@gmail.com", "966666666", "123456");

		Order o1 = new Order(null, Instant.parse("2021-02-23T13:30:56Z"), u1);
		Order o2 = new Order(null, Instant.parse("2021-02-25T17:02:27Z"), u2);
		Order o3 = new Order(null, Instant.parse("2021-02-25T22:34:11Z"), u3);

		userRepository.saveAll(Arrays.asList(u1, u2, u3));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		
	}
	
	

}

package es.eoi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import es.eoi.repository.ClientesRepository;

@SpringBootTest
class AppTests {
	
	@Autowired
	ClientesRepository clientRepository;

	@Test
	void contextLoads() {
		
//		Client c = clientRepository.findById("1234").get();
		
//		Assertions.assertTrue(c.getName().equals("david"));
		
	}

}
